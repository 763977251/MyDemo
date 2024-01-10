package com.shang.demo.StrTest;

import org.apache.commons.lang3.StringUtils;

public class StrTest23 {
    public static void main(String[] args) {
        String str = "1e5";
        String str2 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ecc=\"http://www.konka.com/ESB_I_SCC/Model/MM/ECC\"><soapenv:Header/><soapenv:Body><ecc:MT_0050_MatDocRead_ECC_Req><SYS_INFO><SOURCE_SYS_ID>AKWMS</SOURCE_SYS_ID><TARGET_SYS_ID>DKK020</TARGET_SYS_ID></SYS_INFO><REMARK><REMARK2>6300658714</REMARK2></REMARK><BUSSINESS_ID>999</BUSSINESS_ID><BUDAT_FROM>20231101</BUDAT_FROM><BUDAT_TO>20231201</BUDAT_TO><BUKRS></BUKRS></ecc:MT_0050_MatDocRead_ECC_Req></soapenv:Body></soapenv:Envelope>";
        boolean b = checkStrIsNumber(str);
        System.out.println(b);
    }
    /**
     * 校验是数字（包括科学计数法格式的数字）
     */
    public static boolean checkStrIsNumber(String value) {
        if (StringUtils.isEmpty(value)) {
            return false;
        }
        return value.matches("(\\s)*([+-])?(([0-9]*\\.)?([0-9]+)|([0-9]+)(\\.[0-9]*)?)([eE][\\+-]?[0-9]+)?(\\s)*");
    }
}
