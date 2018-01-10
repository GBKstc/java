
package cn.demo.gbk.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cn.demo.gbk.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SaveCustomer_QNAME = new QName("http://service.gbk.demo.cn/", "saveCustomer");
    private final static QName _FindHasBindingListResponse_QNAME = new QName("http://service.gbk.demo.cn/", "findHasBindingListResponse");
    private final static QName _SaveCustomerResponse_QNAME = new QName("http://service.gbk.demo.cn/", "saveCustomerResponse");
    private final static QName _FindNotBindingListResponse_QNAME = new QName("http://service.gbk.demo.cn/", "findNotBindingListResponse");
    private final static QName _FindAllResponse_QNAME = new QName("http://service.gbk.demo.cn/", "findAllResponse");
    private final static QName _FindHasBindingList_QNAME = new QName("http://service.gbk.demo.cn/", "findHasBindingList");
    private final static QName _FindAll_QNAME = new QName("http://service.gbk.demo.cn/", "findAll");
    private final static QName _FindNotBindingList_QNAME = new QName("http://service.gbk.demo.cn/", "findNotBindingList");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.demo.gbk.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SaveCustomer }
     * 
     */
    public SaveCustomer createSaveCustomer() {
        return new SaveCustomer();
    }

    /**
     * Create an instance of {@link FindHasBindingListResponse }
     * 
     */
    public FindHasBindingListResponse createFindHasBindingListResponse() {
        return new FindHasBindingListResponse();
    }

    /**
     * Create an instance of {@link FindNotBindingListResponse }
     * 
     */
    public FindNotBindingListResponse createFindNotBindingListResponse() {
        return new FindNotBindingListResponse();
    }

    /**
     * Create an instance of {@link SaveCustomerResponse }
     * 
     */
    public SaveCustomerResponse createSaveCustomerResponse() {
        return new SaveCustomerResponse();
    }

    /**
     * Create an instance of {@link FindHasBindingList }
     * 
     */
    public FindHasBindingList createFindHasBindingList() {
        return new FindHasBindingList();
    }

    /**
     * Create an instance of {@link FindAllResponse }
     * 
     */
    public FindAllResponse createFindAllResponse() {
        return new FindAllResponse();
    }

    /**
     * Create an instance of {@link FindAll }
     * 
     */
    public FindAll createFindAll() {
        return new FindAll();
    }

    /**
     * Create an instance of {@link FindNotBindingList }
     * 
     */
    public FindNotBindingList createFindNotBindingList() {
        return new FindNotBindingList();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.gbk.demo.cn/", name = "saveCustomer")
    public JAXBElement<SaveCustomer> createSaveCustomer(SaveCustomer value) {
        return new JAXBElement<SaveCustomer>(_SaveCustomer_QNAME, SaveCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindHasBindingListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.gbk.demo.cn/", name = "findHasBindingListResponse")
    public JAXBElement<FindHasBindingListResponse> createFindHasBindingListResponse(FindHasBindingListResponse value) {
        return new JAXBElement<FindHasBindingListResponse>(_FindHasBindingListResponse_QNAME, FindHasBindingListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.gbk.demo.cn/", name = "saveCustomerResponse")
    public JAXBElement<SaveCustomerResponse> createSaveCustomerResponse(SaveCustomerResponse value) {
        return new JAXBElement<SaveCustomerResponse>(_SaveCustomerResponse_QNAME, SaveCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindNotBindingListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.gbk.demo.cn/", name = "findNotBindingListResponse")
    public JAXBElement<FindNotBindingListResponse> createFindNotBindingListResponse(FindNotBindingListResponse value) {
        return new JAXBElement<FindNotBindingListResponse>(_FindNotBindingListResponse_QNAME, FindNotBindingListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.gbk.demo.cn/", name = "findAllResponse")
    public JAXBElement<FindAllResponse> createFindAllResponse(FindAllResponse value) {
        return new JAXBElement<FindAllResponse>(_FindAllResponse_QNAME, FindAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindHasBindingList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.gbk.demo.cn/", name = "findHasBindingList")
    public JAXBElement<FindHasBindingList> createFindHasBindingList(FindHasBindingList value) {
        return new JAXBElement<FindHasBindingList>(_FindHasBindingList_QNAME, FindHasBindingList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.gbk.demo.cn/", name = "findAll")
    public JAXBElement<FindAll> createFindAll(FindAll value) {
        return new JAXBElement<FindAll>(_FindAll_QNAME, FindAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindNotBindingList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.gbk.demo.cn/", name = "findNotBindingList")
    public JAXBElement<FindNotBindingList> createFindNotBindingList(FindNotBindingList value) {
        return new JAXBElement<FindNotBindingList>(_FindNotBindingList_QNAME, FindNotBindingList.class, null, value);
    }

}
