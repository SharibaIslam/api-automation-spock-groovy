package util

import org.apache.commons.lang3.RandomStringUtils

import java.text.DecimalFormat


class Util {
    public static String readConfigData() throws IOException {
        def ip=new Input();
        def result = ip.input()
        return result;
    }

    public Properties readPropData(){
        Properties prop=new Properties()
        def inputSteam
        try {
            def propFileName = "config.properties"
            inputSteam = getClass().getClassLoader().getResourceAsStream(propFileName)

            if (inputSteam != null) {
                prop.load(inputSteam);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

        }catch(Exception e){
            System.out.println("Exception: " + e)
        }finally {
            inputSteam.close()
        }
        return prop
    }

    public Properties readPropDataLocal(){
        Properties prop=new Properties()
        def inputSteam
        try {
            def propFileName = "localConfig.properties"
            inputSteam = getClass().getClassLoader().getResourceAsStream(propFileName)

            if (inputSteam != null) {
                prop.load(inputSteam);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

        }catch(Exception e){
            System.out.println("Exception: " + e)
        }finally {
            inputSteam.close()
        }
        return prop
    }

    public static String token() throws Exception {
        /*SecondLoginRegSpec secondLoginRegSpec = new SecondLoginRegSpec()
        String aToken = secondLoginRegSpec.sendHeader()
        System.out.printf("Token is " +aToken)
        return aToken*/

    }

    public static String generateRandomMobileNumber(){
        String operatorCode = "0150";
        String phoneNumber = operatorCode + RandomStringUtils.randomNumeric(7);
        return phoneNumber;
    }

    public static Double ConvertToDouble(double value)
    {
        DecimalFormat df=new DecimalFormat( "#.####" );
        Double res=Double.parseDouble( df.format( value ) ) ;
        return res;
    }
    public static String generateRandomNID(){
        String FirstThrreeDigit="114";
        String phoneNumber =FirstThrreeDigit+RandomStringUtils.randomNumeric(10);
        return phoneNumber;
    }



}
