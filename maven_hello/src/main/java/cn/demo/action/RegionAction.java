package cn.demo.action;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.demo.bean.Region;
import cn.demo.service.RegionService;
import cn.demo.service.StaffService;
import cn.demo.utils.PinYin4jUtils;
import cn.demo.utils.SetResult;

public class RegionAction extends BaseAction<Region>{
	private static final long serialVersionUID = 1L;
	List<Region> regionList = new ArrayList<Region>();
	
	private File regionFile;
	public void setRegionFile(File regionFile) {
		this.regionFile = regionFile;
	}

	private RegionService regionService;
	public void setRegionService(RegionService regionService) {
		this.regionService = regionService;
	}

	//文件上传
	public String uploadFile() throws Exception {
		if(regionFile==null) {
			return null;
		}
		//使用POI解析Excel文件
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(regionFile));
		//根据名称获得指定Sheet对象
		HSSFSheet hssfSheet = workbook.getSheet("Sheet1");
		for (Row row : hssfSheet) {
			int rowNum = row.getRowNum();
			if(rowNum == 0){
				continue;
			}
			String id = row.getCell(0).getStringCellValue();
			String province = row.getCell(1).getStringCellValue();
			String city = row.getCell(2).getStringCellValue();
			String district = row.getCell(3).getStringCellValue();
			String postcode = row.getCell(4).getStringCellValue();
			//包装一个区域对象
			Region region = new Region(id, province, city, district, postcode, null, null, null);
			
			province = province.substring(0, province.length() - 1);
			city = city.substring(0, city.length() - 1);
			district = district.substring(0, district.length() - 1);
			String info = province + city + district;
			String[] headByString = PinYin4jUtils.getHeadByString(info);
			String shortcode = StringUtils.join(headByString);
			//城市编码---->>shijiazhuang
			String citycode = PinYin4jUtils.hanziToPinyin(city, "");
			
			region.setShortcode(shortcode);
			region.setCitycode(citycode);
			regionList.add(region);
		}
		//批量保存
		regionService.saveBatch(regionList);
		return NONE;		
	}	

	//获取raffList
	public String getRegionList() throws Exception {
		String json = SetResult.setResult("success", regionService.getRegionList(page,pageSize));
		HttpServletResponse response = ServletActionContext.getResponse();
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}

	
}
