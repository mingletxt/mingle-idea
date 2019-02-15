package com.mingle.excel;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by mingle. Time 2019-01-04 14:24 Desc 文件描述
 */
public class CsvUtils {
    
    private static final String DEFAULT_CSV_ENCODING = "gbk";
    
    private static String BASE_PATH = "/data/logs/beauty-cp/member/";
    
    public static void main(String[] args) throws Exception {
        String mobile = "15026900003";
        File fileRoot = new File(BASE_PATH + mobile);
        File[] fileForMembers = fileRoot.listFiles();
        if (fileForMembers == null || fileForMembers.length == 0) {
            System.out.println("no file");
            return;
        }
        
        List<List<String>> exportList = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("手机号码");
        header.add("会员名称");
        header.add("充值卡");
        header.add("充值金额(分)");
        header.add("剩余金额(分)");
        header.add("单次折扣");
        header.add("疗程卡折扣");
        header.add("产品折扣");
        header.add("购买时间");
        header.add("描述");
        exportList.add(header);
    
        for (File fileForMember : fileForMembers) {
            if (!fileForMember.isDirectory()) {
                System.out.println("importToMeiYe file is not dir." + fileForMember);
                continue;
            }
    
            File[] fileForMemberInfos = fileForMember.listFiles();
            if (fileForMemberInfos == null || fileForMemberInfos.length == 0) {
                System.out.println("importToMeiYe fileForMemberInfo is empty." + fileForMember);
                continue;
            }
    
            for (File fileForMemberInfo : fileForMemberInfos) {
                if (fileForMemberInfo.getName().startsWith("RECHARGE-CARD")) {
                    //List<RechargeModel> list = toObjList(fileData, LiaoChengKaModel.class);
                }
            }
        }
    
        List<String> content = new ArrayList<>();
        content.add("18927161773");
        content.add("通用帐户");
        content.add("100000");
        content.add("1000");
        content.add("8");
        content.add("7");
        content.add("6");
        exportList.add(content);
        exportList.add(content);
        export("/Users/mingle/Downloads/text.csv", exportList, DEFAULT_CSV_ENCODING);
        
    }
    
    /**
     * 导出到文件
     *
     * @param list list.size()就代表有多少行
     */
    public static void export(String filePath, List<List<String>> list, String encoding) throws Exception {
        if (StringUtils.isBlank(filePath)) {
            throw new RuntimeException("保存的路径不能为空");
        }
        
        initDir(filePath);
        
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        CSVPrinter csvFilePrinter = null;
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withSkipHeaderRecord();
        try {
            fos = new FileOutputStream(filePath);
            osw = new OutputStreamWriter(fos, encoding);
            csvFilePrinter = new CSVPrinter(osw, csvFileFormat);
            for (int i = 0; i < list.size(); i++) {
                csvFilePrinter.printRecord(list.get(i));
            }
            osw.flush();
        } catch (Exception e) {
            throw e;
        } finally {
            IOUtils.closeQuietly(csvFilePrinter);
            IOUtils.closeQuietly(osw);
            IOUtils.closeQuietly(fos);
        }
    }
    
    private static void initDir(String filePath) {
        File file = new File(filePath);
        File parentDir = file.getParentFile();
        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }
    }
}
