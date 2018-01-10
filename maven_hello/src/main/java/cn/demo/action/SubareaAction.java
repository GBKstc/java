package cn.demo.action;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import cn.demo.bean.Region;
import cn.demo.bean.Subarea;
import cn.demo.service.SubareaService;
import cn.demo.utils.FileUtils;
import cn.demo.utils.SetResult;

public class SubareaAction extends BaseAction<Subarea>{
	private static final long serialVersionUID = 1L;

	private SubareaService subareaService;
	public void setSubareaService(SubareaService subareaService) {
		this.subareaService = subareaService;
	}


	//获取SubareaList
	public String getSubareaList() throws Exception {
		String json = SetResult.setResult("success", subareaService.getSubareaList(page,pageSize,model));
		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().write(json);
		return null;
	}

	//添加staff
	public String addSubarea() throws Exception {
		subareaService.addSubarea(model);
		String json = SetResult.setDefaultResult();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().write(json);
		return null;
	}
	
	//导出Subarea
	public String subareaExport() throws Exception {
		List<Subarea> list = subareaService.getSubareaList();
		HSSFWorkbook workbook = new HSSFWorkbook();//创建文件
		HSSFSheet sheet = workbook.createSheet("分区数据");//创建标签页
		HSSFRow hssfRow = sheet.createRow(0);//创建标题行
		hssfRow.createCell(0).setCellValue("分区编号");
		hssfRow.createCell(1).setCellValue("开始编号");
		hssfRow.createCell(2).setCellValue("结束编号");
		hssfRow.createCell(3).setCellValue("位置信息");
		hssfRow.createCell(4).setCellValue("省市区");
		//创建数据行
		for (Subarea subarea : list) {
			HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum()+1);
			dataRow.createCell(0).setCellValue(subarea.getId());
			dataRow.createCell(1).setCellValue(subarea.getStartnum());
			dataRow.createCell(2).setCellValue(subarea.getEndnum());
			dataRow.createCell(3).setCellValue(subarea.getPosition());
			Region region = subarea.getRegion();
			dataRow.createCell(4).setCellValue(region.getProvince()+region.getCity()+region.getDistrict());
		}
		
		//使用输出流输出文件
		String filename = "分区数据.xls";
		String contentType = ServletActionContext.getServletContext().getMimeType(filename);
		HttpServletResponse response = ServletActionContext.getResponse();
		ServletOutputStream outputStream = response.getOutputStream();
		response.setContentType(contentType);
		
		//获取浏览器类型
		String agent = ServletActionContext.getRequest().getHeader("User-Agent");
		filename = FileUtils.encodeDownloadFilename(filename, agent);
		response.setHeader("content-disposition", "attachment;filename="+filename);
		workbook.write(outputStream);
		
		return null;
	}
	
}
