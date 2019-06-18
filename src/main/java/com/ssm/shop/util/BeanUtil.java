package com.ssm.shop.util;

import java.io.File;
import java.io.FileWriter;


/**
 * 代码生成工具
 * ClassName: BeanUtil 
 * @Description: TODO
 * @author micoMo
 * @date 2017-9-16
 */
@SuppressWarnings("unchecked")
public class BeanUtil {
	
	//首行缩进BEGIN
	private static final String B1 ="	";
	private static final String B2 ="		";
	private static final String B3 ="			";
	
	//换行END
	private static final String E1 = "\r\n";
	private static final String E2 = "\r\n\r\n";

	//文件 地址
	private static final String ACTION_PATH = "main/java/com/ssm/shop/controller";
	private static final String SERVICE_INTER_PATH = "main/java/com/ssm/shop/service/inter";
	private static final String SERVICE_IMPL_PATH = "main/java/com/ssm/shop/service/impl";
	//E:/idea-workspace/shop/src/com/ssm/shop/
	public static void createCodeTool(Class c) throws Exception{
		createBeanServiceInter(c);
		createBeanServiceImpl(c);
		createBeanAction(c);
	}
	
	
	/**
	 * 创建beanAction
	 * @Description: TODO
	 * @param @param c
	 * @param @throws Exception   
	 * @return void  
	 * @throws
	 * @author micoMo
	 * @date 2017-9-16
	 */
    private static void createBeanAction(Class c) throws Exception{
    	String cName = c.getSimpleName();
    	String cname = getLowercaseChar(cName);
		String fileName = System.getProperty("user.dir") + "/src/" + ACTION_PATH
				+ "/" + cName + "Controller.java";
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		String code =      
				"package com.ssm.shop.controller;"+E2+

				"import java.util.List;"+E1+
				"import com.ssm.shop.util.StringTool;"+E1+
				"import javax.annotation.Resource;"+E1+
				"import javax.servlet.http.HttpServletResponse;"+E1+
				"import org.springframework.stereotype.Controller;"+E1+
				"import com.ssm.shop.http.HttpResult;"+E1+
				"import org.springframework.web.bind.annotation.RestController;"+E1+
				"import org.springframework.beans.factory.annotation.Autowired;"+E1+
				"import org.springframework.web.bind.annotation.ResponseBody;"+E1+
				"import org.springframework.web.bind.annotation.RequestMapping;"+E1+
				"import com.ssm.shop.pojo."+cName+";"+E1+
				"import com.ssm.shop.service.inter."+cName+"Service;"+E1+E2+

		
				"@RestController"+E1+
				"@RequestMapping(\"/"+cname+"\")"+E1+
				"public class "+cName+"Controller {"+E2+
					
					B1+"@Autowired"+E1+
					B1+"private "+cName+"Service "+cname+"Service;"+E2+
					
					B1+"@RequestMapping(\"/getById\")"+E1+
					B1+"public @ResponseBody HttpResult getById(int id) {"+E2+
		
						B2+"if(StringTool.isEmpty(String.valueOf(id))){"+E1+
							B2+"return HttpResult.error(\"id不能为空!\");"+E1+
						B2+"}else {"+E1+
							B2+"return HttpResult.ok(\"显示成功\","+cname+"Service.get"+cName+"(id));"+E1+
						B2+"}"+E2+
						
					B1+"}"+E2+
					
				
					B1+"@RequestMapping(\"/list"+cName+"ByPage\")"+E1+
					B1+"public @ResponseBody HttpResult list"+cName+"ByPage("+cName+" "+cname+"){"+E2+
						
						B2+"return HttpResult.ok("+cname+"Service.list"+cName+"ByPage("+cname+"));"+E1+
						
					B1+"}"+E2+
					
					B1+"@RequestMapping(\"/insert"+cName+"\")"+E1+
					B1+"public @ResponseBody HttpResult insert"+cName+"("+cName+" "+cname+"){"+E2+
						B2+""+cname+"Service.save"+cName+"("+cname+");"+E2+
						B2+"return HttpResult.ok(\"添加成功\");"+E1+
						
					B1+"}"+E2+
					
					B1+"@RequestMapping(\"/update"+cName+"\")"+E1+
					B1+"public @ResponseBody HttpResult update"+cName+"("+cName+" "+cname+"){"+E2+
						B2+""+cname+"Service.update"+cName+"("+cname+");"+E2+
						B2+"return HttpResult.ok(\"修改成功\");"+E1+
						
					B1+"}"+E2+
					
					B1+"@RequestMapping(\"/delete"+cName+"\")"+E1+
					B1+"public @ResponseBody HttpResult delete"+cName+"(int id){"+E2+
						B2+""+cname+"Service.delete"+cName+"(id);"+E2+
						B2+"return HttpResult.ok(\"删除成功\");"+E1+
						
					B1+"}"+E2+
							
				"}";

		fw.write(code);
		fw.flush();
		fw.close();
		showInfo(fileName);
    }
    
    /**
     * 创建beanServiceInter
     * @Description: TODO
     * @param @param c
     * @param @throws Exception   
     * @return void  
     * @throws
     * @author micoMo
     * @date 2017-9-16
     */
    private static void createBeanServiceInter(Class c) throws Exception{
    	String cName = c.getSimpleName();
    	String cname = getLowercaseChar(cName);
		String fileName = System.getProperty("user.dir") + "/src/" + SERVICE_INTER_PATH
				+ "/" + cName + "Service.java";
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		String code =      
						"package com.ssm.shop.service.inter;"+E2+
	
						"import java.util.List;"+E1+
						"import com.ssm.shop.page.PageResult;"+E1+
						"import com.ssm.shop.pojo."+cName+";"+E2+
	
						"public interface "+cName+"Service {"+E2+
	
							B1+"List<"+cName+"> list"+cName+"("+cName+" "+cname+");"+E2+
							
							B1+"PageResult list"+cName+"ByPage("+cName+" "+cname+");"+E2+
							
							B1+"int selectCount("+cName+" "+cname+");"+E2+
							
							B1+"void save"+cName+"("+cName+" "+cname+");"+E2+
							
							B1+"void delete"+cName+"(long id);"+E2+
							
							B1+"void update"+cName+"("+cName+" "+cname+");"+E2+
							
							B1+""+cName+" get"+cName+"(long id);"+E2+
						
						 "}";
		
		fw.write(code);
		fw.flush();
		fw.close();
		showInfo(fileName);
    }
    
    /**
     * 创建beanServiceImpl
     * @Description: TODO
     * @param @param c
     * @param @throws Exception   
     * @return void  
     * @throws
     * @author micoMo
     * @date 2017-9-16
     */
    private static void createBeanServiceImpl(Class c) throws Exception{
    	String cName = c.getSimpleName();
    	String cname = getLowercaseChar(cName);
    	
    	String fileName = System.getProperty("user.dir") + "/src/" + SERVICE_IMPL_PATH 
    			+ "/" + cName +"ServiceImpl.java";
    	File f = new File(fileName);
    	FileWriter fw = new FileWriter(f);
		String code =      
				    "package com.ssm.shop.service.impl;"+E2+

					"import java.util.HashMap;"+E1+
					"import java.util.List;"+E1+
					"import javax.annotation.Resource;"+E1+
					"import org.springframework.stereotype.Service;"+E1+
					"import com.ssm.shop.dao."+cName+"Mapper;"+E1+
					"import com.ssm.shop.page.PageResult;"+E1+
					"import com.ssm.shop.pojo."+cName+";"+E1+
					"import com.ssm.shop.service.inter."+cName+"Service;"+E1+
					"import org.springframework.stereotype.Service;"+E1+
					"import org.springframework.beans.factory.annotation.Autowired;"+E2+


					"@Service"+E1+
					"public class "+cName+"ServiceImpl implements "+cName+"Service {"+E2+
						
						B1+"@Autowired"+E1+
						B1+"private "+cName+"Mapper "+cName+"Mapper;"+E2+
						
						B1+"@Override"+E1+
						B1+"public List<"+cName+"> list"+cName+"("+cName+" record){"+E2+
							B2+"return null;"+E2+
						B1+"}"+E2+
						
						B1+"@Override"+E1+
						B1+"public PageResult list"+cName+"ByPage("+cName+" record){"+E2+
							B2+"int total = "+cName+"Mapper.selectCount(record);"+E2+
							B2+"record.setCurrentPage((record.getCurrentPage()-1)*record.getPageSize());"+E2+
							B2+"List<"+cName+"> rows="+cName+"Mapper.list"+cName+"ByPage(record);"+E2+
							B2+"return new PageResult(record.getCurrentPage()+1,record.getPageSize(),total, rows);"+E2+
						B1+"}"+E2+
						
						B1+"@Override"+E1+
						B1+"public int selectCount("+cName+" record){"+E2+
							B2+"return 0;"+E2+
						B1+"}"+E2+
						
						B1+"@Override"+E1+
						B1+"public void save"+cName+"("+cName+" "+cname+"){"+E1+
							B2+""+cName+"Mapper.insert("+cname+");"+E2+
						B1+"}"+E2+
						
						B1+"@Override"+E1+
						B1+"public "+cName+" get"+cName+"(long id){"+E1+
							B2+"return "+cName+"Mapper.selectByPrimaryKey(id);"+
						B1+"}"+E2+
						
						B1+"@Override"+E1+
						B1+"public void update"+cName+"("+cName+" "+cname+"){"+E1+
							B2+""+cName+"Mapper.updateByPrimaryKeySelective("+cname+");"+E2+
						B1+"}"+E2+
						
						B1+"@Override"+E1+
						B1+"public void delete"+cName+"(long id){"+E1+
							B2+""+cName+"Mapper.deleteByPrimaryKey(id);"+E2+
						B1+"}"+E2+
			
					"}";

		fw.write(code);
    	fw.flush();
		fw.close();
		showInfo(fileName);
    }
	
	/**
	 * 把第一个字母变为小写<br>
	 * @Description: TODO
	 * @param @param str
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author micoMo
	 * @date 2017-9-16
	 */
	private static String getLowercaseChar(String str){
		return str.substring(0,1).toLowerCase()+str.substring(1);
	}

	/**
	 * 显示信息
	 * @Description: TODO
	 * @param @param info   
	 * @return void  
	 * @throws
	 * @author micoMo
	 * @date 2017-9-16
	 */
	private static void showInfo(String info){
		System.out.println("创建文件："+ info+ "成功！");
	}
	
}
