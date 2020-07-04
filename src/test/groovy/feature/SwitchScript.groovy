package feature

import api.APIListFoSwitch
import io.qameta.allure.Allure
import model.User
import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll
import util.Util

class SwitchScript extends Specification {
    public static APIListFoSwitch apiList = new APIListFoSwitch()
    public static User user = new User()
    Date time = new Date(System.currentTimeMillis())

    //@Ignore
    @Unroll("1. Intrabank Distributor Registration")
    def '1. Distributor Registration'() {
        when:
        def response = apiList.distributorRegistration(user)
        def ss = response.status

        then:
        response.status==200
        def json=response.responseData
        json.status=="SUCCESS"
    }
    //@Ignore
   @Unroll("2. Intrabank Activation of Distributor")
    def '2. Intrabank Activation of Distributor'() {
        when:
        def response = apiList.activateDistributor(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="SUCCESS"


    }
    //@Ignore
    @Unroll("3. Intrabank Set PIN of Distributor")
    def '3. Intrabank Set PIN of Distributor'() {
        when:
        def response = apiList.setPINOfIntraBankDistributor(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="SUCCESS"
        json.acStatus=="Active"


    }
    //@Ignore
    @Unroll("4. IB Distributor Registration")
    def '4. IB Distributor Registration'() {
        when:
        def response = apiList.distributorRegistrationIB(user)
        def ss = response.status

        then:
        response.status==200
        def json=response.responseData
        json.status=="SUCCESS"
    }
    //@Ignore
    @Unroll("5. IB Activation of Distributor")
    def '5. IB Activation of Distributor'() {
        when:
        def response = apiList.activateDistributorIB(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="SUCCESS"
    }
    //@Ignore
    @Unroll("6. IB Set PIN of Distributor")
    def '6. IB Set PIN of Distributor'() {
        when:
        def response = apiList.setPINOfIBDistributor(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="SUCCESS"
        json.acStatus=="Active"
    }
    //@Ignore
    @Unroll("7. Intra Agent Registration")
    def '7. Intra Agent Registration'() {
        when:
        def response = apiList.intraBankAgentRegistration(user)
        def ss = response.status

        then:
        response.status==200
        def json=response.responseData
        json.status=="SUCCESS"
    }
    //@Ignore
    @Unroll("8. Intra Activation of Agent")
    def '8. Intra Activation of Agent'() {
        when:
        def response = apiList.activateIntraAgent(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="SUCCESS"


    }
    //@Ignore
    @Unroll("9. Intra Set PIN of Agent")
    def '9. Intra Set PIN of Agent'() {
        when:
        def response = apiList.setPINOfIntraAgent(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="SUCCESS"
        json.acStatus=="Active"
    }
    //@Ignore
    @Unroll("10. IB Agent Registration")
    def '10. IB Agent Registration'() {
        when:
        def response = apiList.ibBankAgentRegistration(user)
        def ss = response.status
        def json=response.responseData
        then:
        response.status==200
        json.status=="SUCCESS"
    }
    //@Ignore
    @Unroll("11. IB Activation of Agent")
    def '11. IB Activation of Agent'() {
        when:
        def response = apiList.activateIBAgent(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="SUCCESS"
    }
    //@Ignore
    @Unroll("12. IB Set PIN of Agent")
    def '12. IB Set PIN of Agent'() {
        when:
        def response = apiList.setPINOfIBAgent(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="SUCCESS"
        json.acStatus=="Active"
    }
    //@Ignore
    @Unroll("13. AD Agent Registration")
    def '13. AD Agent Registration'() {
        when:
        def response = apiList.adAgentRegistration(user)
        def ss = response.status
        def json=response.responseData
        then:
        response.status==200
        json.status=="SUCCESS"
    }
    //@Ignore
    @Unroll("14. AD Agent Activation")
    def '14. AD Agent Activation'() {
        when:
        def response = apiList.activateADAgent(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="SUCCESS"

    }
    //@Ignore
    @Unroll("15. AD Agent Set PIN")
    def '15. AD Agent Set PIN'() {
        when:
        def response = apiList.setPINOfADAgent(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="SUCCESS"
        json.acStatus=="Active"


    }
    //@Ignore
    @Unroll("16. Intra Customer Registration")
    def '16. Intra Custome Registration'() {
        when:
        def response = apiList.intraBankCustomer(user)
        def ss = response.status
        def json=response.responseData
        then:
        response.status==200
        json.status=="SUCCESS"
    }
    //@Ignore
    @Unroll("17. Intra Customer Activation")
    def '17. Intra Customer Activation'() {
        when:
        def response = apiList.activateIntraCustomer(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="SUCCESS"

    }
    //@Ignore
    @Unroll("18. Intra Customert Set PIN")
    def '18. Intra Customer Set PIN'() {
        when:
        def response = apiList.setPINOfIntraBankCustomer(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="SUCCESS"
        json.acStatus=="Active"


    }
    //@Ignore
    @Unroll("19. IB Customer Registration")
    def '19. IB Customer Registration'() {
        when:
        def response = apiList.ibCustomerRegistration(user)
        def ss = response.status
        def json=response.responseData
        then:
        response.status==200
        json.status=="SUCCESS"
    }
    //@Ignore
    @Unroll("20. IB Customer Activation")
    def '20. IB Customer Activation'() {
        when:
        def response = apiList.activateIBCustomer(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="SUCCESS"

    }
    //@Ignore
    @Unroll("21. IB Customer Set PIN")
    def '21. IB Customer Set PIN'() {
        when:
        def response = apiList.setPINOfIBCustomer(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="SUCCESS"
        json.acStatus=="Active"


    }
    //@Ignore
    @Unroll("22. ADC Customer Registration")
    def '22. ADC Customer Registration'() {
        when:
        def response = apiList.adcCustomerRegistration(user)
        def ss = response.status
        def json=response.responseData
        then:
        response.status==200
        json.status=="SUCCESS"
    }
    //@Ignore
    @Unroll("23. ADC Customer Activation")
    def '23. ADC Customer Activation'() {
        when:
        def response = apiList.activateADCustomer(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="SUCCESS"

    }
    //@Ignore
    @Unroll("24. ADC Customer Set PIN")
    def '24. ADC Customer Set PIN'() {
        when:
        def response = apiList.setPINOfADCCustomer(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="SUCCESS"
        json.acStatus=="Active"


    }
    //@Ignore
    @Unroll("25. Bank Cash-in to intra Distributor")
    def '25. Bank Cash-in to intra Distributor'() {
        when:
        def response = apiList.bankCashInToIntraDis(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="PROCESSED"


    }
    //@Ignore
    @Unroll("26. Bank Cash-in to IB Distributor")
    def '26. Bank Cash-in to IB Distributor'() {
        when:
        def response = apiList.bankCashInToIBDis(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="PROCESSED"


    }
    //@Ignore
    @Unroll("27. Bank Cash-out from intra Distributor")
    def '27. Bank Cash-out from intra Distributor'() {
        when:
        def response = apiList.bankCashOutFromIntraDis(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="PROCESSED"


    }

    //@Ignore
    @Unroll("28. Bank Cash-out from ib Distributor")
    def '28. Bank Cash-out from ib Distributor'() {
        when:
        def response = apiList.bankCashOutFromIBDis(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="PROCESSED"


    }
    //@Ignore
    @Unroll("29. Distributor Cash-in to Intra Agent")
    def '29. Distributor Cash-in to Intra Agent'() {
        when:
        def response = apiList.disToIntraAgentCashIn(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="PROCESSED"


    }
    //@Ignore
    @Unroll("30. Distributor Cash-in to IB Agent")
    def '30. Distributor Cash-in to IB Agent'() {
        when:
        def response = apiList.disToIBAgentCashIn(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="PROCESSED"


    }
    //@Ignore
    @Unroll("31. Distributor Cash-in to AD Agent")
    def '31. Distributor Cash-in to AD Agent'() {
        when:
        def response = apiList.disToADAgentCashIn(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="PROCESSED"


    }
    //@Ignore
    @Unroll("32. Distributor Cash-out to Intra Agent")
    def '32. Distributor Cash-out to Intra Agent'() {
        when:
        def response = apiList.disToIntraAgentCashOut(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="PROCESSED"


    }
    //@Ignore
    @Unroll("33. Distributor Cash-out to IB Agent")
    def '33. Distributor Cash-out to IB Agent'() {
        when:
        def response = apiList.disToIBAgentCashOut(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="PROCESSED"


    }
    //@Ignore
    @Unroll("34. Distributor Cash-out to AD Agent")
    def '34. Distributor Cash-out to AD Agent'() {
        when:
        def response = apiList.disToADAgentCashOut(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="PROCESSED"


    }
    //@Ignore
    @Unroll("35. Intra Agent Cash-in to Intra Customer Cash-in")
    def '35. Intra Agent Cash-in to Intra Customer Cash-in'() {
        when:
        def response = apiList.intraAgentToIntraCusCashIN(user)
        def json=response.responseData
        print(json)
        double amount=json.trnxAmount
        double expectedAgentCommission=Util.ConvertToDouble((amount*0.4174)/100)
        double expctedDistcom=Util.ConvertToDouble((amount*0.1753)/100)

        then:
        response.status==200
        json.status=="PROCESSED"


    }
    //@Ignore
    @Unroll("36. IB Agent Cash-in to Intra Customer Cash-in")
    def '36. IB Agent Cash-in to Intra Customer Cash-in'() {
        when:
        def response = apiList.ibAgentToIntraCusCashIN(user)
        def json=response.responseData
        print(json)
        double amount=json.trnxAmount
        double expectedAgentCommission=Util.ConvertToDouble((amount*0.4174)/100)
        double expctedDistcom=Util.ConvertToDouble((amount*0.1753)/100)
        double expcteIBFee=Util.ConvertToDouble((amount*0.6585)/100)

        then:
        response.status==200
        json.status=="PROCESSED"
        json.ibFeeCr==expcteIBFee

    }
    //@Ignore
    @Unroll("37. AD Agent Cash-in to Intra Customer Cash-in")
    def '37. Intra Agent Cash-in to IB Customer Cash-in'() {
        when:
        def response = apiList.adAgentToIntraCusCashIN(user)
        def json=response.responseData
        print(json)
        double amount=json.trnxAmount
        double expectedAgentCommission=Util.ConvertToDouble((amount*0.4174)/100)
        double expctedDistcom=Util.ConvertToDouble((amount*0.1753)/100)
        double expcteIBFee=Util.ConvertToDouble((amount*0.6585)/100)

        then:
        response.status==200
        json.status=="PROCESSED"
        json.ibFeeCr==expcteIBFee

    }
    //@Ignore
    @Unroll("38. Intra Agent to ADC Customer Cash-in")
    def '38. Intra Agent to ADC Customer Cash-in'() {
        when:
        def response = apiList.intraAgentToADCCusCashIN(user)
        def json=response.responseData
        print(json)
        double amount=json.trnxAmount
        double expectedAgentCommission=Util.ConvertToDouble((amount*0.4174)/100)
        double expctedDistcom=Util.ConvertToDouble((amount*0.1753)/100)
        double expcteIBFee=Util.ConvertToDouble((amount*0.6585)/100)

        then:
        response.status==200
        json.status=="PROCESSED"
        json.ibFeeCr==expcteIBFee

    }

    //@Ignore
    @Unroll("39. Intra Agent to Intra Customer Cash-Out")
    def '39. Intra Agent to Intra Customer Cash-Out'() {
        when:
        def response = apiList.intraAgentToIntraCusCasOut(user)
        def json=response.responseData
        print(json)
        double amount=json.trnxAmount
        double expectedAgentCommission=Util.ConvertToDouble((amount*0.4174)/100)
        double expctedDistcom=Util.ConvertToDouble((amount*0.1753)/100)
        //double expectedFee=Util.ConvertToDouble((amount*1.80)/100)
        //For free withdraw
        double expectedFee=(((amount-1000.0)*1.80)/100)

        then:
        response.status==200
        json.status=="PROCESSED"
        json.fee==expectedFee

    }

    //@Ignore
    @Unroll("40. IB Agent to Intra Customer Cash-Out")
    def '40. IB Agent to Intra Customer Cash-Out'() {
        when:
        def response = apiList.ibAgentToIntraCusCasOut(user)
        def json=response.responseData
        print(json)
        double amount=json.trnxAmount
        double expectedAgentCommission=Util.ConvertToDouble((amount*0.4174)/100)
        double expctedDistcom=Util.ConvertToDouble((amount*0.1753)/100)
        double expectedFee=Util.ConvertToDouble((amount*1.80)/100)
        double expcteIBFee=Util.ConvertToDouble((amount*0.689)/100)

        then:
        response.status==200
        json.status=="PROCESSED"
        json.fee==expectedFee
        json.ibFeeDr==expcteIBFee

    }
    //@Ignore
    @Unroll("41. Intra Agent to ADC Customer Cash-Out")
    def '41. Intra Agent to ADC Customer Cash-Out'() {
        when:
        def response = apiList.intraAgentToADCCusCasOut(user)
        def json=response.responseData
        print(json)
        double amount=json.trnxAmount
        double expectedAgentCommission=Util.ConvertToDouble((amount*0.4174)/100)
        double expctedDistcom=Util.ConvertToDouble((amount*0.1753)/100)
        //double expectedFee=Util.ConvertToDouble((amount*1.80)/100)
        double expcteIBFee=Util.ConvertToDouble((amount*0.689)/100)
        //For free withdraw
        double expectedFee=(((amount-1000.0)*1.80)/100)

        then:
        response.status==200
        json.status=="PROCESSED"
        //json.fee==expectedFee
        json.ibFeeDr==expcteIBFee


    }
    //@Ignore
    @Unroll("42. AD Agent to Intra Customer Cash-Out")
    def '42. AD Agent to Intra Customer Cash-Out'() {
        when:
        def response = apiList.adAgentToIntraCusCasOut(user)
        def json=response.responseData
        print(json)
        double amount=json.trnxAmount
        double expectedAgentCommission=Util.ConvertToDouble((amount*0.4174)/100)
        double expctedDistcom=Util.ConvertToDouble((amount*0.1753)/100)
        double expectedFee=Util.ConvertToDouble((amount*1.80)/100)
        double expcteIBFee=Util.ConvertToDouble((amount*0.689)/100)

        then:
        response.status==200
        json.status=="PROCESSED"
        json.fee==expectedFee
        json.ibFeeDr==expcteIBFee

    }

    //@Ignore
    @Unroll("43. Retailer Tag Add Inta Bank")
    def '43. Retailer Tag Add Inta Bank'() {
        when:
        def response = apiList.retailerTagAddIntaBank(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="SUCCESS"
    }

    //@Ignore
    @Unroll("44. Retailer Tag Add IB Bank")
    def '44. Retailer Tag Add IB Bank'() {
        when:
        def response = apiList.retailerTagAddIBBank(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="SUCCESS"
    }

    //@Ignore
    @Unroll("45. Intra customer to intra customer Send Money")
    def '45. Intra customer to intra customer Send Money'() {
        when:
        def response = apiList.intraCusToIntraCusSendMoney(user)

        def response2 = apiList.userGetTypeForIntra(user)
        def json = response.responseData
        def json2 = response2.responseData
        print(json)
        def purposeOfTrxn = json2.purposeOfTxn

        then:
        if (purposeOfTrxn.contains("RETAILER")) {
            assert json.fee == 0.0
            assert response.status==200
            assert json.status=="PROCESSED"
            println("Free withdraw: Fee=0" )
        } else {
            assert json.fee == 4.0
            assert response.status==200
            assert json.status=="PROCESSED"
            println("Free withdraw: Fee=4" )
        }

    }



    //@Ignore
    @Unroll("46. Intra customer to ib customer Send Money")
    def '46. Intra customer to ib customer Send Money'() {
        when:
        def response = apiList.intraCusToIBCusSendMoney(user)
        def response2 = apiList.userGetTypeForIB(user)
        def json=response.responseData
        def json2=response2.responseData
        print(json)
        double amount=json.trnxAmount
        double expectedReceiverToSenderIbFee= Util.ConvertToDouble((amount*0.6585)/100)
        double expectedSenderToReceiverIbFee= Util.ConvertToDouble(1.0434)
        def purposeOfTrxn=json2.purposeOfTxn

        then:
        if(purposeOfTrxn.contains("RETAILER")){
            assert json.fee==0.0
            assert json.ibFeeCr==expectedReceiverToSenderIbFee
            assert response.status==200
            json.status=="PROCESSED"

        }
        else{
            assert json.fee==4.0
            assert json.ibFeeCr==expectedReceiverToSenderIbFee
            //assert json.ibFeeDr==expectedSenderToReceiverIbFee
            assert response.status==200
            json.status=="PROCESSED"
        }


    }

    //@Ignore
    @Unroll("47. Intra customer to adc customer Send Money")
    def '47. Intra customer to adc customer Send Money'() {
        when:
        def response = apiList.intraCusToADCCusSendMoney(user)
        def response2 = apiList.userGetTypeForAdc(user)
        def json=response.responseData
        def json2=response2.responseData
        print(json)
        double amount=json.trnxAmount
        double expectedReceiverToSenderIbFee= Util.ConvertToDouble((amount*0.6585)/100)
        double expectedSenderToReceiverIbFee= Util.ConvertToDouble(1.0434)
        def purposeOfTrxn=json2.purposeOfTxn

        then:
        if(purposeOfTrxn.contains("RETAILER")){
            assert json.fee==0.0
            assert json.ibFeeDr==expectedSenderToReceiverIbFee
            assert response.status==200
            json.status=="PROCESSED"

        }
        else{
            assert json.fee==4.0
            //assert json.ibFeeCr==expectedReceiverToSenderIbFee
            //assert json.ibFeeDr==expectedSenderToReceiverIbFee
            assert response.status==200
            json.status=="PROCESSED"
        }


    }

    //@Ignore
    @Unroll("48. Retailer Tag Remove Intra Bank")
    def '48. Retailer Tag Remove Intra Bank'() {
        when:
        def response = apiList.retailerTagRemoveIntraBank(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="SUCCESS"
    }

    //@Ignore
    @Unroll("49. Retailer Tag Remove IB Bank")
    def '49. Retailer Tag Remove IB Bank'() {
        when:
        def response = apiList.retailerTagRemoveIBBank(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="SUCCESS"
    }

    //@Ignore
    @Unroll("50. Intra Cus To Intra Merchant Payment")
    def '50. Intra CusTo Intra Merchant Payment'() {
        when:
        def response = apiList.intraCusToIntraMerchantPayment(user)
        def json=response.responseData
        print(json)
        double amount=json.trnxAmount
        double minFee=4
        then:
        response.status==200
        json.status=="PROCESSED"


    }
    //@Ignore
    @Unroll("51. Intra Cus To IB Merchant Payment Fee From Cus Min Amount")
    def '51. Intra Cus To IB Merchant Payment Fee From Cus Min Amount'() {
        when:
        def response = apiList.intraCusToIBMerchantPaymentFeeFromCusMinPayment(user)
        def json=response.responseData
        print(json)
        double amount=json.trnxAmount
        double minFee=4
        double expcteIBFee=Util.ConvertToDouble((((minFee*78.26)/100)-((amount*0.6585)/100))/3)
        def expcteIBFeeNew=String.format("%.3f",expcteIBFee)
        double actualIbFee=json.ibFeeDr
        def actualIbFeeNew=String.format("%.3f",actualIbFee)
        then:
        response.status==200
        json.status=="PROCESSED"
        expcteIBFeeNew==actualIbFeeNew


    }

    //@Ignore
    @Unroll("52. Intra Cus To IB Merchant Payment Fee From Cus General Amount")
    def '52. Intra Cus To IB Merchant Payment Fee From Cus General Amount'() {
        when:
        Thread.sleep(5000);
        def response = apiList.intraCusToIBMerchantPaymentFeeFromCusGeneralPayment(user)
        def json = response.responseData
        print(json)
        double amount=json.trnxAmount
        double expectedFee=Util.ConvertToDouble((amount*1)/100)
        double expcteIBFee=Util.ConvertToDouble((((expectedFee*78.26)/100)-((amount*0.6585)/100))/3)
        def expcteIBFeeNew=String.format("%.3f",expcteIBFee)
        double actualIbFee=json.ibFeeDr
        def actualIbFeeNew=String.format("%.3f",actualIbFee)
        then:
        response.status==200
        json.status=="PROCESSED"
        expcteIBFeeNew==actualIbFeeNew
        sleep(3000)


    }

    //@Ignore
    @Unroll("53. Intra Cus To IB Merchant Payment Fee From Cus Max Amount")
    def '53. Intra Cus To IB Merchant Payment Fee From Cus MAx Amount'() {
        when:
        Thread.sleep(5000);
        def response = apiList.intraCusToIBMerchantPaymentFeeFromCusMaxPayment(user)
        def json=response.responseData
        print(json)
        double amount=json.trnxAmount
        def maxFee=30
        double expcteIBFee=Util.ConvertToDouble((((maxFee*78.26)/100)-((amount*0.6585)/100))/3)
        def expcteIBFeeNew=String.format("%.3f",expcteIBFee)
        def actualIbFee=json.ibFeeDr
        def actualIbFeeNew=String.format("%.3f",actualIbFee)
        then:
        response.status==200
        json.status=="PROCESSED"
        sleep(3000)

    }

    //@Ignore
    @Unroll("54. Intra Cus To IB Merchant Payment Fee From Merchant Min Amount")
    def '54. Intra Cus To IB Merchant Payment Fee From Merchant Min Amount'() {
        when:
        def response = apiList.intraCusToIBMerchantPaymentFeeFromMerchantMinPayment(user)
        def json=response.responseData
        print(json)
        double amount=json.trnxAmount
        def minFee=4
        double expcteIBFee=Util.ConvertToDouble(((((minFee*78.26)/100)-((amount*0.6585)/100))*2/3)+((amount*0.6585)/100))
        def expcteIBFeeNew=String.format("%.3f",expcteIBFee)
        double actualIbFee=json.ibFeeCr
        def actualIbFeeNew=String.format("%.3f",actualIbFee)
        then:
        response.status==200
        json.status=="PROCESSED"
        expcteIBFeeNew==actualIbFeeNew
    }

    //@Ignore
    @Unroll("55. Intra Cus To IB Merchant Payment Fee From Merchant General Amount")
    def '55. Intra Cus To IB Merchant Payment Fee From Merchant General Amount'() {
        when:
        Thread.sleep(5000);
        def response = apiList.intraCusToIBMerchantPaymentFeeFromMerchantGeneralPayment(user)
        def json=response.responseData
        print(json)
        double amount=json.trnxAmount
        double expectedFee=Util.ConvertToDouble((amount*1)/100)
        double expcteIBFee=Util.ConvertToDouble(((((expectedFee*78.26)/100)-((amount*0.6585)/100))*2/3)+((amount*0.6585)/100))
        def expcteIBFeeNew=String.format("%.3f",expcteIBFee)
        double actualIbFee=json.ibFeeCr
        def actualIbFeeNew=String.format("%.3f",actualIbFee)
        then:
        response.status==200
        json.status=="PROCESSED"
        expcteIBFeeNew==actualIbFeeNew
        sleep(3000)
    }

    //@Ignore
    @Unroll("56. Intra Cus To IB Merchant Payment Fee From Merchant Max Amount")
    def '56. Intra Cus To IB Merchant Payment Fee From Merchant Max Amount'() {
        when:
        Thread.sleep(5000);
        def response = apiList.intraCusToIBMerchantPaymentFeeFromMerchantMaxPayment(user)
        def json=response.responseData
        print(json)
        double amount=json.trnxAmount
        double maxFee=25
        double expcteIBFee=Util.ConvertToDouble((maxFee*78.26)/100)
        def expcteIBFeeNew=String.format("%.3f",expcteIBFee)
        double actualIbFee=json.ibFeeCr
        def actualIbFeeNew=String.format("%.3f",actualIbFee)
        then:
        response.status==200
        json.status=="PROCESSED"
        expcteIBFeeNew==actualIbFeeNew
        sleep(3000)
    }

    //@Ignore
    @Unroll("57. Intra Agent To Intra Merchant Payment")
    def '57. Intra Agent To Intra Merchant Payment'() {
        when:
        def response = apiList.intraAgentToIntraMerchantPayment(user)
        def json=response.responseData
        print(json)
        double amount=json.trnxAmount
        double expectedFee=Util.ConvertToDouble((amount*1)/100)
        double expectedAgentCommission=Util.ConvertToDouble((amount*0.4174)/100)
        double expctedDistcom=Util.ConvertToDouble((amount*0.1753)/100)

        then:
        response.status==200
        json.status=="PROCESSED"

    }

    //@Ignore
    @Unroll("58. Ib Agent To Intra Merchant Payment")
    def '58. Ib Agent To Intra Merchant Payment'() {
        when:
        def response = apiList.ibAgentToIntraMerchantPayment(user)
        def json=response.responseData
        print(json)
        double amount=json.trnxAmount
        double expectedFee=Util.ConvertToDouble((amount*1)/100)
        double expectedAgentCommission=Util.ConvertToDouble((amount*0.4174)/100)
        double expctedDistcom=Util.ConvertToDouble((amount*0.1753)/100)

        then:
        response.status==200
        json.status=="PROCESSED"

    }

    //@Ignore
    @Unroll("59. Ad Agent To Intra Merchant Payment")
    def '59. Ad Agent To Intra Merchant Payment'() {
        when:
        def response = apiList.adAgentToIntraMerchantPayment(user)
        def json=response.responseData
        print(json)
        double amount=json.trnxAmount
        double expectedFee=Util.ConvertToDouble((amount*1)/100)
        double expectedAgentCommission=Util.ConvertToDouble((amount*0.4174)/100)
        double expctedDistcom=Util.ConvertToDouble((amount*0.1753)/100)

        then:
        response.status==200
        json.status=="PROCESSED"

    }

    //@Ignore
    @Unroll("60. Intra Agent To IB Merchant Payment Fee From Customer Min Amount")
    def '60. Intra Agent To IB Merchant Payment Fee From Customer Min Amount'() {
        when:
        def response = apiList.intraAgentToIBMerchantPaymentFeeFromCustomerMinAmount(user)
        def json=response.responseData
        print(json)
        double amount=json.trnxAmount
        def minFee=4
        double expectedAgentCommission=Util.ConvertToDouble((minFee*41.74)/100)
        double expctedDistcom=Util.ConvertToDouble((minFee*17.53)/100)
        double expcteIBFee=Util.ConvertToDouble((((minFee*78.26)/100)-((minFee*65.85)/100))/3)
        def expcteIBFeeNew=String.format("%.4f",expcteIBFee)
        double actualIbFee=json.ibFeeDr
        def actualIbFeeNew=String.format("%.4f",actualIbFee)

        then:
        response.status==200
        json.status=="PROCESSED"
        actualIbFeeNew==expcteIBFeeNew
        json.fee==minFee

    }

    //@Ignore
    @Unroll("61. Intra Agent To IB Merchant Payment Fee From Customer General Amount")
    def '61. Intra Agent To IB Merchant Payment Fee From Customer General Amount'() {
        when:
        Thread.sleep(5000);
        def response = apiList.intraAgentToIBMerchantPaymentFeeFromCustomerGeneralAmount(user)
        def json=response.responseData
        print(json)
        double amount=json.trnxAmount
        double expectedAgentCommission=Util.ConvertToDouble((amount*0.4174)/100)
        double expctedDistcom=Util.ConvertToDouble((amount*0.1753)/100)
        double expectedFee=Util.ConvertToDouble((amount*1)/100)
        double expcteIBFee=Util.ConvertToDouble((((expectedFee*78.26)/100)-((amount*0.6585)/100))/3)
        def expcteIBFeeNew=String.format("%.4f",expcteIBFee)
        double actualIbFee=json.ibFeeDr
        def actualIbFeeNew=String.format("%.4f",actualIbFee)

        then:
        response.status==200
        json.status=="PROCESSED"
        actualIbFeeNew==expcteIBFeeNew
        json.fee==expectedFee
        sleep(3000)

    }

    //@Ignore
    @Unroll("62. Intra Agent To IB Merchant Payment Fee From Customer Max Amount")
    def '62. Intra Agent To IB Merchant Payment Fee From Customer Max Amount'() {
        when:
        Thread.sleep(5000);
        def response = apiList.intraAgentToIBMerchantPaymentFeeFromCustomerMaxAmount(user)
        def json=response.responseData
        print(json)
        double amount=json.trnxAmount
        double maxFee=30.0
        double expectedAgentCommission=Util.ConvertToDouble((maxFee*41.74)/100)
        double expctedDistcom=Util.ConvertToDouble((maxFee*17.53)/100)
        double expcteIBFee=Util.ConvertToDouble((((maxFee*78.26)/100)-((maxFee*65.85)/100))/3)
        def expcteIBFeeNew=String.format("%.3f",expcteIBFee)
        double actualIbFee=json.ibFeeDr
        def actualIbFeeNew=String.format("%.3f",actualIbFee)


        then:
        response.status==200
        json.status=="PROCESSED"
        json.fee==maxFee
        actualIbFeeNew==expcteIBFeeNew
        sleep(3000)

    }

    //@Ignore
    @Unroll("63. Ib Agent To IB Merchant Payment Fee From Customer")
    def '63. Ib Agent To IB Merchant Payment Fee From Customer'() {
        when:
        def response = apiList.ibAgentToIBMerchantPaymentFeeFromCustomer(user)
        def json=response.responseData
        print(json)
        double amount=json.trnxAmount
        double minFee=4.0

        then:
        response.status==200
        json.status=="PROCESSED"
        json.fee==minFee

    }

    //@Ignore
    @Unroll("64. Ad Agent To IB Merchant Payment Fee From Customer")
    def '64. adAgentToIBMerchantPaymentFeeFromCustomer'() {
        when:
        def response = apiList.adAgentToIBMerchantPaymentFeeFromCustomer(user)
        def json=response.responseData
        print(json)
        double amount=json.trnxAmount
        double expectedAgentCommission=Util.ConvertToDouble((amount*0.4174)/100)
        double expctedDistcom=Util.ConvertToDouble((amount*0.1753)/100)
        double expectedFee=Util.ConvertToDouble((amount*1)/100)


        then:
        response.status==200
        json.status=="PROCESSED"
        //json.fee==expectedFee

    }
    //@Ignore
    @Unroll("65. Intra Agent To IB Merchant Payment Fee From Merchant Min Amount")
    def '65. adAgentToIBMerchantPaymentFeeFromCustomer'() {
        when:
        def response = apiList.intraAgentToIBMerchantPaymentFeeFromMerchantMinAmount(user)
        def json=response.responseData
        print(json)
        double amount=json.trnxAmount
        def minFee=4
        double expectedAgentCommission=Util.ConvertToDouble((minFee*41.74)/100)
        double expctedDistcom=Util.ConvertToDouble((minFee*17.53)/100)
        double expcteIBFee=Util.ConvertToDouble(((((minFee*78.26)/100)-((minFee*65.85)/100))*2/3))+((minFee*65.85)/100)
        def expcteIBFeeNew=String.format("%.3f",expcteIBFee)
        double actualIbFee=json.ibFeeCr
        def actualIbFeeNew=String.format("%.3f",actualIbFee)

        then:
        response.status==200
        json.status=="PROCESSED"
        actualIbFeeNew==expcteIBFeeNew

    }
    //@Ignore
    @Unroll("66. Intra Agent To IB Merchant Payment Fee From Merchant General Amount")
    def '66. Intra Agent To IB Merchant Payment Fee From Merchant General Amount'() {
        when:
        Thread.sleep(5000);
        def response = apiList.intraAgentToIBMerchantPaymentFeeFromMerchantGeneralAmount(user)
        def json=response.responseData
        print(json)
        double amount=json.trnxAmount
        double expectedAgentCommission=Util.ConvertToDouble((amount*0.4174)/100)
        double expctedDistcom=Util.ConvertToDouble((amount*0.1753)/100)
        double expectedFee=Util.ConvertToDouble((amount*1)/100)
        double expcteIBFee=Util.ConvertToDouble(((((expectedFee*78.26)/100)-((amount*0.6585)/100))*2/3)+((amount*0.6585)/100))
        def expcteIBFeeNew=String.format("%.3f",expcteIBFee)
        double actualIbFee=json.ibFeeCr
        def actualIbFeeNew=String.format("%.3f",actualIbFee)

        then:
        response.status==200
        json.status=="PROCESSED"
        actualIbFeeNew==expcteIBFeeNew
        sleep(3000)

    }
    //@Ignore
    @Unroll("67. Intra Agent To IB Merchant Payment Fee From Merchant MaxAmount")
    def '67. Intra Agent To IB Merchant Payment Fee From Merchant MaxAmount'() {
        when:
        Thread.sleep(5000);
        def response = apiList.intraAgentToIBMerchantPaymentFeeFromMerchantMaxAmount(user)
        def json=response.responseData
        print(json)
        double amount=json.trnxAmount
        def minFee=100


        then:
        response.status==200
        json.status=="PROCESSED"
        //actualIbFeeNew==expcteIBFeeNew

    }
    //@Ignore
    @Unroll("68. Ib Agent To IB Merchant Payment Fee From Merchant")
    def '68. Ib Agent To IB Merchant Payment Fee From Merchant'() {
        when:
        def response = apiList.ibAgentToIBMerchantPaymentFeeFromMerchant(user)
        def json=response.responseData
        print(json)
        double amount=json.trnxAmount
        def maxFee=30
        double expectedAgentCommission=Util.ConvertToDouble((amount*0.4174)/100)
        double expctedDistcom=Util.ConvertToDouble((amount*0.1753)/100)
        double expectedFee=Util.ConvertToDouble((amount*1)/100)

        then:
        response.status==200
        json.status=="PROCESSED"
        sleep(3000)

    }
    //@Ignore
    @Unroll("69. Ad Agent To IB Merchant Payment Fee From Merchant")
    def '69. Ad Agent To IB Merchant Payment Fee From Merchant'() {
        when:
        def response = apiList.adAgentToIBMerchantPaymentFeeFromMerchant(user)
        def json=response.responseData
        print(json)
        double amount=json.trnxAmount
        double expectedAgentCommission=Util.ConvertToDouble((amount*0.4174)/100)
        double expctedDistcom=Util.ConvertToDouble((amount*0.1753)/100)
        double expectedFee=Util.ConvertToDouble((amount*1)/100)

        then:
        response.status==200
        json.status=="PROCESSED"

    }

    //@Ignore
    @Unroll("70. Bulk disburse to Intra Customer")
    def '70. Bulk disburse to Intra Customer'() {
        when:
        def response = apiList.bulkDisburseToIntraCustomer(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status==["PROCESSED"]

    }

    //@Ignore
    @Unroll("71. Bulk disburse to IB Customer")
    def '71. Bulk disburse to IB Customer'() {
        when:
        def response = apiList.bulkDisburseToIBCustomer(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status==["PROCESSED"]

    }

    //@Ignore
    @Unroll("72. Bulk disburse to ADC Customer")
    def '72. Bulk disburse to ADC Customer'() {
        when:
        def response = apiList.bulkDisburseToADCCustomer(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status==["PROCESSED"]

    }

    //@Ignore
    @Unroll("73. Bulk cash-out of IB customer")
    def '73. Bulk cash-out of IB customer'() {
        when:
        def response = apiList.bulkCashOutIB(user)
        def json=response.responseData
        print(json)
        double amount=json.trnxAmount
        double expectedAgentCommission=Util.ConvertToDouble((amount*0.4174)/100)
        double expctedDistcom=Util.ConvertToDouble((amount*0.1753)/100)
        //double expectedFee=Util.ConvertToDouble((amount*1.80)/100)
        //For free withdraw
        double expectedFee=(((amount)*1.80)/100)
        //For free withdraw, ib fee will be general ibfee, not disburse rate
        double expcteIBFee=Util.ConvertToDouble((amount*0.6738)/100)

        then:
        response.status==200
        json.status=="PROCESSED"
        //json.fee==expectedFee
        json.ibFeeDr==expcteIBFee

    }

    //@Ignore
    @Unroll("74. Bulk cash-out of Intra customer")
    def '74. Bulk cash-out of Intra customer'() {
        when:
        def response = apiList.bulkCashOutIntra(user)
        def json=response.responseData
        print(json)
        double amount=json.trnxAmount
        double expectedAgentCommission=Util.ConvertToDouble((amount*0.4174)/100)
        double expctedDistcom=Util.ConvertToDouble((amount*0.1753)/100)
        //double expectedFee=Util.ConvertToDouble((amount*1.80)/100)
        //For free withdraw
        double expectedFee=(((amount)*1)/100)

        then:
        response.status==200
        json.status=="PROCESSED"
        json.fee==expectedFee

    }

    //@Ignore
    @Unroll("75. DO to Intra Agent Cash-in")
    def '75. DO to Intra Agent Cash-in'() {
        when:
        def response = apiList.doToIntraAgentCashIN(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="PROCESSED"

    }

    //@Ignore
    @Unroll("76. DO to IB Agent Cash-in")
    def '76. DO to IB Agent Cash-in'() {
        when:
        def response = apiList.doToIBAgentCashIN(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="PROCESSED"

    }

    //@Ignore
    @Unroll("77. DO to Intra Agent Cash-out")
    def '77. DO to Intra Agent Cash-out'() {
        when:
        def response = apiList.doToIntraAgentCashOut(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="PROCESSED"

    }

    //@Ignore
    @Unroll("78. DO to IB AgeBnt Cash-out")
    def '78. DO to IB Agent Cash-out'() {
        when:
        def response = apiList.doToIBAgentCashOut(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="PROCESSED"

    }

    //@Ignore
    @Unroll("79. Merchant to Merchant payment")
    def '79. Merchant to Merchant payment'() {
        when:
        def response = apiList.m2mPayment(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="PROCESSED"

    }

    //@Ignore
    @Unroll("80. Merchant Cash-out from intra agent")
    def '80. Merchant Cash-out from intra agent'() {
        when:
        def response = apiList.merchantCashOutIntra(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="PROCESSED"

    }

    //@Ignore
    @Unroll("81. Merchant Cash-out from IB agent")
    def '81. Merchant Cash-out from IB agent'() {
        when:
        def response = apiList.merchantCashOutIB(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="PROCESSED"

    }

    //@Ignore
    @Unroll("82. Merchant Cash-out from AD agent")
    def '82. Merchant Cash-out from AD agent'() {
        when:
        def response = apiList.merchantCashOutADAgent(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="PROCESSED"

    }

    //@Ignore
    @Unroll("83. Stipend Customer registration")
    def '83. Stipend Customer registration'() {
        when:
        def response = apiList.stipendRegistration(user)
        //def json=response.responseData
        //print(json)

        then:
        response.status==200
        //json.status=="SUCCESS"

    }

    //@Ignore
    @Unroll("84. Stipend Disburse")
    def '84. Stipend Disburse'() {
        when:
        def response = apiList.stipendDisburse(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="PROCESSED"

    }

    @Unroll("85. Stipend Cash-out from Intrabank agent")
    def '85. Stipend Cash-out from Intrabank agent'() {
        when:
        def response = apiList.stipendCashOutIntra(user)
        def json=response.responseData
        double amount=json.trnxAmount
        double expectedAgentCommission=Util.ConvertToDouble((amount*0.4174)/100)
        double expctedDistcom=Util.ConvertToDouble((amount*0.1753)/100)
        //double expectedFee=Util.ConvertToDouble((amount*1.80)/100)
        //For free withdraw
        double expectedFee=(((amount-1000.0)*1.80)/100)
        double expcteIBFee=Util.ConvertToDouble((amount*0.6738)/100)

        then:
        response.status==200
        json.status=="PROCESSED"
        json.fee==0
        //json.ibFeeDr==expcteIBFee

    }

    @Unroll("86. Stipend Cash-out from IB agent")
    def '86. Stipend Cash-out from IB agent'() {
        when:
        def response = apiList.stipendCashOutIB(user)
        def json=response.responseData
        double amount=json.trnxAmount
        double expectedAgentCommission=Util.ConvertToDouble((amount*0.4174)/100)
        double expctedDistcom=Util.ConvertToDouble((amount*0.1753)/100)
        //double expectedFee=Util.ConvertToDouble((amount*1.80)/100)
        //For free withdraw
        double expectedFee=(((amount-1000.0)*1.80)/100)
        double expcteIBFee=Util.ConvertToDouble((amount*0.6738)/100)

        then:
        response.status==200
        json.status=="PROCESSED"
        json.fee==0
        //json.ibFeeDr==expcteIBFee

    }

    @Unroll("87. Sugar Cash-out from Intra agent")
    def '87. Sugar Cash-out from Intra agent'() {
        when:
        def response = apiList.sugarCustomerWithdrawIntra(user)
        def json=response.responseData
        double amount=json.trnxAmount
        double expectedAgentCommission=Util.ConvertToDouble((amount*0.4174)/100)
        double expctedDistcom=Util.ConvertToDouble((amount*0.1753)/100)
        //double expectedFee=Util.ConvertToDouble((amount*1.80)/100)
        //For free withdraw
        double expectedFee=(((amount-1000.0)*1.80)/100)
        double expcteIBFee=Util.ConvertToDouble((amount*0.6738)/100)

        then:
        response.status==200
        json.status=="PROCESSED"
        json.fee==0
        //json.ibFeeDr==expcteIBFee

    }

    @Unroll("88. Sugar Cash-out from IB agent")
    def '88. Sugar Cash-out from IB agent'() {
        when:
        def response = apiList.sugarCustomerWithdrawIB(user)
        def json=response.responseData
        double amount=json.trnxAmount
        double expectedAgentCommission=Util.ConvertToDouble((amount*0.4174)/100)
        double expctedDistcom=Util.ConvertToDouble((amount*0.1753)/100)
        //double expectedFee=Util.ConvertToDouble((amount*1.80)/100)
        //For free withdraw
        double expectedFee=(((amount-1000.0)*1.80)/100)
        double expcteIBFee=Util.ConvertToDouble((amount*0.6738)/100)

        then:
        response.status==200
        json.status=="PROCESSED"
        json.fee==0
        json.ibFeeDr==expcteIBFee

    }
    //@Ignore
    @Unroll("89. Get Balance of Distributor")
    def '89. Get Balance of Distributor'() {
        when:
        def response = apiList.distGetBalance(user)
        def json=response.responseData
        def ss=response.status

        print(json)

        then:
        if(response.status in [200]){
            assert ss ==200
            Allure.addDescription("balance is" +json)
        }
        else {
            assert ss ==400
        }

    }

    //@Ignore
    @Unroll("90. Get Balance with right PIN")
    def '90. Get Balance with right PIN'() {
        when:
        def response = apiList.getBalanceWithRightPIN(user)
        def json=response.responseData
        def ss=response.status
        def balance=json.balance

        print(json)

        then:
        if(response.status in [200]){
            assert ss ==200
            assert json.status=="SUCCESS"
            Allure.addDescription("balance is" +balance)
            println(balance)
        }
        else {
            assert ss ==400
        }
    }

    //@Ignore
    @Unroll("91. Negative case: get balance with wrong PIN")
    def '91. Negative case: get balance with wrong PIN'() {
        when:
        def response = apiList.getBalanceWithWrongPIN(user)
        def json=response.responseData
        def ss=response.status
        def balance=json.balance

        print(json)

        then:
        if(response.status in [200,400]){
            assert ss ==400
            assert json.status=="FAILED"
            Allure.addDescription("balance is" +balance)
            println(balance)
        }
        else {
            assert ss ==400
        }
    }


    //@Ignore
    @Unroll("92. Reverse Payment Intra bank")
    def '92. Reverse Payment Intra bank'() {
        when:
        def response = apiList.reversePaymentIntraBank(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.reversalStatus=="SUCCESS"

    }

    @Ignore
    @Unroll("93. Reverse Payment Inter Bank")
    def '93. Reverse Payment Inter Bank'() {
        when:
        def response = apiList.reversePaymentIB(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.reversalStatus=="SUCCESS"

    }

    //@Ignore
    @Unroll("94. Check cred of a user with right PIN")
    def '94. Check cred of a user with right PIN'() {
        when:
        def response = apiList.userCheckCredWithRightPIN(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="VALID"
        def errorMsg=json.status
        Allure.addDescription("Message:" +errorMsg)
    }

    //@Ignore
    @Unroll("95. Negative case: check cred with wrong PIN")
    def '95. Negative case: check cred with wrong PIN'() {
        when:
        def response = apiList.userCheckCredWithWrongPIN(user)
        def json=response.responseData
        print(json)

        then:
        if(response.status in [200]){
            assert response.status ==200
            assert json.status=="INVALID"
            def errorMsg=json.status
            Allure.addDescription("Error message:" +errorMsg)
        }
        else {
            assert ss ==400
        }
    }

    //@Ignore
    @Unroll("96. Direct top up with ROBI and AIRTEL")
    def '96. Direct top up with ROBI and AIRTEL'() {
        when:
        def response = apiList.directTopUpWithRobiAirtel(user)
        def json=response.responseData
        print(json)

        then:
        if(response.status in [200]){
            assert response.status ==200
            assert json.status=="PENDING"
        }
        else {
            assert ss ==400
        }
    }

    @Unroll("97. top UpWith Other Operator")
    def '97. top Up With Other Operator'() {
        when:
        def response = apiList.topUpWithOtherOperator(user)
        def json=response.responseData
        print(json)

        then:
        if(response.status in [200]){
            assert response.status ==200
            assert json.status=="PENDING"
        }
        else {
            assert ss ==400
        }
    }

    @Unroll("98. Negative case: topup with wrong PIN")
    def '98. Negative case: topup with wrong PIN'() {
        when:
        def response = apiList.topUpWithWrongPIN(user)
        def json=response.responseData
        print(json)

        then:
        if(response.status in [200]){
            assert response.status ==200
            assert json.status=="INVALID_CREDENTIALS"
            def errorMsg=json.status
            Allure.addDescription("Error message:" +errorMsg)
        }
        else {
            assert ss ==400
        }
    }


    //@Ignore
    @Unroll("99. Agent Swapping")
    def '99. Agent Swapping'() {
        when:
        def response = apiList.agentSwapping(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="SUCCESS"
    }

    //@Ignore
    @Unroll("100. Change Status")
    def '100. Change Status'() {
        when:
        def response = apiList.changeStatus(user)
        def json=response.responseData
        print(json)

        then:
        response.status==200
        json.status=="SUCCESS"
    }
    //@Ignore
    @Unroll("101. Change PIN with right PIN")
    def '101. Change PIN with right PIN'() {
        when:
        def response = apiList.changePINWithRightPIN(user)
        def json=response.responseData
        print(json)

        then:
        if(response.status in [200]){
            assert response.status ==200
            assert json.status=="SUCCESS"
        }
        else {
            assert ss ==400
        }
    }

    //@Ignore
    @Unroll("102. Negative case: change PIN with wrong PIN")
    def '102. Negative case: change PIN with wrong PIN'() {
        when:
        def response = apiList.changePINWithWrongPIN(user)
        def json=response.responseData
        print(json)

        then:
        if(response.status in [200]){
            assert response.status ==200
            assert json.message=="Invalid credential"
            def errorMsg=json.status
            Allure.addDescription("Error message:" +errorMsg)
        }
        else {
            assert ss ==400
        }
    }
    //@Ignore
    @Unroll("103. Negative case: change PIN with wrong PIN")
    def '103. Negative case: change PIN with wrong PIN'() {
        when:
        def response = apiList.changePINWithWrongPIN(user)
        def json=response.responseData
        print(json)

        then:
        if(response.status in [200]){
            assert response.status ==200
            assert json.message=="Invalid credential"
            def errorMsg=json.status
            Allure.addDescription("Error message:" +errorMsg)
        }
        else {
            assert ss ==400
        }
    }

    //@Ignore
    @Unroll("104. Negative case: do payment txn with wrong PIN")
    def '104. Negative case: do payment txn with wrong PIN'() {
        when:
        def response = apiList.txnWithWrongPIN(user)
        def json=response.responseData
        print(json)

        then:
        if(response.status in [200]){
            assert response.status ==200
            assert json.status=="INVALID_CREDENTIALS"
            def errorMsg=json.status
            Allure.addDescription("Error message:" +errorMsg)
        }
        else {
            assert ss ==400
        }
    }

    //@Ignore
    @Unroll("105. Enable reset PIN option")
    def '105. Enable reset PIN option'() {
        when:
        def response = apiList.enableResetPINMenu(user)
        def json=response.responseData
        print(json)

        then:
        if(response.status in [200]){
            assert response.status ==200
            assert json.status=="SUCCESS"
        }
        else {
            assert ss ==400
        }
    }

    //@Ignore
    @Unroll("106. Negative case: When suspended customer in destination and receive cash-in from Ad-Agent")
    def '106. Negative case: When suspended customer in destination and receive cash-in from Ad-Agent'() {
        when:
        def response = apiList.adAgentToSuspendedIntraCusCashIN(user)
        def json=response.responseData
        print(json)

        then:
        if(response.status in [200]){
            assert response.status ==200
            assert json.status=="INVALID TO STATUS FOR  TXN. Status: active Reversal Status :SUCCESS"
            def errorMsg=json.status
            Allure.addDescription("Error message:" +errorMsg)
        }
        else {
            assert ss ==400
        }
    }

    //@Ignore
    @Unroll("107. Negative case: When suspended customer in source and do cash-out from Ad-Agent")
    def '107. Negative case: When suspended customer in source and do cash-out from Ad-Agent'() {
        when:
        def response = apiList.adAgentToIntraSuspendedCusCasOut(user)
        def json=response.responseData
        print(json)

        then:
        if(response.status in [200]){
            assert response.status ==200
            assert json.status=="INVALID FROM STATUS FOR  TXN. Status: suspended"
            def errorMsg=json.status
            Allure.addDescription("Error message:" +errorMsg)
        }
        else {
            assert ss ==400
        }
    }

}
