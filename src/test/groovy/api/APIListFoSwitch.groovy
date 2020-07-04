package api

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import groovyx.net.http.HttpResponseDecorator
import groovyx.net.http.HttpResponseException
import groovyx.net.http.RESTClient
import javafx.scene.text.TextBuilder
import model.User
import spock.lang.Shared
import util.Util

class APIListFoSwitch {
    @Shared
    public def restClient = new RESTClient(ApiPath.hostURL)
    public def restClient2 = new RESTClient(ApiPath.hostURL2)
    Util util = new Util()
    //staging
    Properties prop = util.readPropData()
    //local
    /*Properties prop = util.readPropDataLocal()*/
    Date time = new Date(System.currentTimeMillis())
    public static String distributorWallet
    public static String distributorWalletIB
    public static String intraAgentWallet
    public static String ibAgentWallet
    public static String adAgentWallet
    public static String intraCustomerWallet
    public static String ibCustomerWallet
    public static String adcCustomerWallet
    public static String stipendCustomer
    public static String intraTxnID
    public static String ibTxnID
    public static final String phnNumber = Util.generateRandomMobileNumber();
    public static final String phnNumber2 = Util.generateRandomMobileNumber();
    public static final String phnNumber3 = Util.generateRandomMobileNumber();
    public static final String phnNumber4 = Util.generateRandomMobileNumber();
    public static final String phnNumber5 = Util.generateRandomMobileNumber();
    public static final String phnNumber6 = Util.generateRandomMobileNumber();
    public static final String phnNumber7 = Util.generateRandomMobileNumber();
    public static final String phnNumber8 = Util.generateRandomMobileNumber();
    public static final String phnNumber9 = Util.generateRandomMobileNumber();
    public static final String nid1 = Util.generateRandomNID();
    public static final String nid2 = Util.generateRandomNID();
    public static final String nid3 = Util.generateRandomNID();

    def distributorRegistration(User user) {
        def status
        HttpResponseDecorator response
        def bankName = prop.getProperty("intraBank")
        def auth = prop.getProperty("auth")
        def regPath = ApiPath.regPath

        when:
        def requestBody = [
                requestAgent          : "WEB",
                fullName              : "Test Distributor TB3",
                email                 : "",
                pin                   : "2468",
                userPin               : "2468",
                userWallet            : "",
                generatedPin          : true,
                userPinEntered        : false,
                hasInitialDeposit     : false,
                registerLogId         : 0,
                userType              : "Distributor",
                fatherName            : "",
                motherName            : "",
                birthday              : "",
                gender                : "",
                mobilePhone           : phnNumber,
                accountNumber         : "",
                occupation            : "",
                addressOffice         : "Banani",
                villageAreaOffice     : "Dhaka",
                psThanaOffice         : "545",
                districtOffice        : "19",
                unionOffice           : "",
                postCodeOffice        : "",
                addressPresent        : "Banani",
                villageAreaPresent    : "Dhaka",
                psThanaPresent        : "538",
                districtPresent       : "19",
                unionPresent          : "",
                postCodePresent       : "",
                addressPermanent      : "",
                villageAreaPermanent  : "",
                psThanaPermanent      : "",
                districtPermanent     : "",
                unionPermanent        : "",
                postCodePermanent     : "",
                nameIntroducer        : "",
                mobileNumberIntroducer: "",
                photographUrl         : "",
                fileUrl               : "",
                fileIdNumber          : "",
                orgAgentAc            : "",
                assignedBank          : "",
                bankName              : bankName,
                branchName            : "",
                status                : "8",
                distributorBankName   : "",
                distributorWallet     : "",
                srWallet              : "",
                nameOfProprietor      : "",
                businessTerritoryId   : "68",
                businessRegionId      : "15",
                businessAreaId        : "1",
                introducerRelation    : "",
                tradeLicenseNumber    : "",
                tradeLicenseAuthority : "",
                taxId                 : "",
                txnProfileId          : "10",
                alternate_mobile_no   : "",
                nominee_age           : 0,
                merchantWallet        : "",
                disableSMS            : true,
                disableAgentSMS       : true
        ]
        println "Distributor Registration request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: regPath,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator
            def json = response.responseData
            distributorWallet = json.accountNo

        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "Distributor Registration response: " + new JsonBuilder(response.responseData).toPrettyString()
        return response

    }

    def activateDistributor(User user) {
        HttpResponseDecorator response
        def bank = prop.getProperty("intraBank")
        def auth = prop.getProperty("auth")
        def path = ApiPath.regActivationPath

        when:
        def requestBody = [
                agentWalletNo: "",
                bank         : bank,
                userType     : "Distributor",
                userWalletNo : distributorWallet

        ]
        println "Distributor Activation request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "Distributor Activation response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def setPINOfIntraBankDistributor(User user) {
        HttpResponseDecorator response
        def bank = prop.getProperty("intraBank")
        def auth = prop.getProperty("auth")
        def pin = prop.getProperty("pin")
        def path = ApiPath.setPINPath

        when:
        def requestBody = [
                walletNumber: distributorWallet,
                oldPin      : "",
                newPin      : pin,


        ]
        println "Distributor set PIN request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "Distributor set PIN response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def distributorRegistrationIB(User user) {
        def status
        HttpResponseDecorator response
        def bankName = prop.getProperty("ibBank")
        def auth = prop.getProperty("auth")
        def regPath = ApiPath.regPath

        when:
        def requestBody = [
                requestAgent          : "WEB",
                fullName              : "Test Distributor TB3",
                email                 : "",
                pin                   : "2468",
                userPin               : "2468",
                userWallet            : "",
                generatedPin          : true,
                userPinEntered        : false,
                hasInitialDeposit     : false,
                registerLogId         : 0,
                userType              : "Distributor",
                fatherName            : "",
                motherName            : "",
                birthday              : "",
                gender                : "",
                mobilePhone           : phnNumber2,
                accountNumber         : "",
                occupation            : "",
                addressOffice         : "Banani",
                villageAreaOffice     : "Dhaka",
                psThanaOffice         : "545",
                districtOffice        : "19",
                unionOffice           : "",
                postCodeOffice        : "",
                addressPresent        : "Banani",
                villageAreaPresent    : "Dhaka",
                psThanaPresent        : "538",
                districtPresent       : "19",
                unionPresent          : "",
                postCodePresent       : "",
                addressPermanent      : "",
                villageAreaPermanent  : "",
                psThanaPermanent      : "",
                districtPermanent     : "",
                unionPermanent        : "",
                postCodePermanent     : "",
                nameIntroducer        : "",
                mobileNumberIntroducer: "",
                photographUrl         : "",
                fileUrl               : "",
                fileIdNumber          : "",
                orgAgentAc            : "",
                assignedBank          : "",
                bankName              : bankName,
                branchName            : "",
                status                : "8",
                distributorBankName   : "",
                distributorWallet     : "",
                srWallet              : "",
                nameOfProprietor      : "",
                businessTerritoryId   : "68",
                businessRegionId      : "15",
                businessAreaId        : "1",
                introducerRelation    : "",
                tradeLicenseNumber    : "",
                tradeLicenseAuthority : "",
                taxId                 : "",
                txnProfileId          : "10",
                alternate_mobile_no   : "",
                nominee_age           : 0,
                merchantWallet        : "",
                disableSMS            : true,
                disableAgentSMS       : true
        ]
        println "Distributor Registration IB request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: regPath,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator
            def json = response.responseData
            distributorWalletIB = json.accountNo

        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "Distributor Registration IB response: " + new JsonBuilder(response.responseData).toPrettyString()
        return response

    }

    def activateDistributorIB(User user) {
        HttpResponseDecorator response
        def bank = prop.getProperty("ibBank")
        def auth = prop.getProperty("auth")
        def path = ApiPath.regActivationPath

        when:
        def requestBody = [
                agentWalletNo: "",
                bank         : bank,
                userType     : "Distributor",
                userWalletNo : distributorWalletIB

        ]
        println "Distributor Activation IB request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "Distributor Activation IB response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def setPINOfIBDistributor(User user) {
        HttpResponseDecorator response
        def bank = prop.getProperty("ibBank")
        def auth = prop.getProperty("auth")
        def pin = prop.getProperty("pin")
        def path = ApiPath.setPINPath

        when:
        def requestBody = [
                walletNumber: distributorWalletIB,
                oldPin      : "",
                newPin      : pin,


        ]
        println "IB Distributor set PIN request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "IB Distributor set PIN response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def intraBankAgentRegistration(User user) {
        def status
        HttpResponseDecorator response
        def bankName = prop.getProperty("intraBank")
        def auth = prop.getProperty("auth")
        def regPath = ApiPath.regPath

        when:
        def requestBody = [
                requestAgent          : "WEB",
                fullName              : "Test Agent TB3",
                email                 : "",
                pin                   : "2468",
                userPin               : "2468",
                userWallet            : "",
                generatedPin          : true,
                userPinEntered        : false,
                hasInitialDeposit     : false,
                registerLogId         : 0,
                userType              : "Agent",
                fatherName            : "",
                motherName            : "",
                birthday              : "",
                gender                : "",
                mobilePhone           : phnNumber3,
                accountNumber         : "",
                occupation            : "",
                addressOffice         : "Banani",
                villageAreaOffice     : "Dhaka",
                psThanaOffice         : "545",
                districtOffice        : "19",
                unionOffice           : "",
                postCodeOffice        : "",
                addressPresent        : "Banani",
                villageAreaPresent    : "Dhaka",
                psThanaPresent        : "538",
                districtPresent       : "19",
                unionPresent          : "",
                postCodePresent       : "",
                addressPermanent      : "",
                villageAreaPermanent  : "",
                psThanaPermanent      : "",
                districtPermanent     : "",
                unionPermanent        : "",
                postCodePermanent     : "",
                nameIntroducer        : "",
                mobileNumberIntroducer: "",
                photographUrl         : "",
                fileUrl               : "",
                fileIdNumber          : "",
                orgAgentAc            : "",
                assignedBank          : "",
                bankName              : bankName,
                branchName            : "",
                status                : "8",
                distributorBankName   : "",
                distributorWallet     : distributorWallet,
                srWallet              : "",
                nameOfProprietor      : "",
                businessTerritoryId   : "68",
                businessRegionId      : "15",
                businessAreaId        : "1",
                introducerRelation    : "",
                tradeLicenseNumber    : "",
                tradeLicenseAuthority : "",
                taxId                 : "",
                txnProfileId          : "10",
                alternate_mobile_no   : "",
                nominee_age           : 0,
                merchantWallet        : "",
                disableSMS            : true,
                disableAgentSMS       : true
        ]
        println "Intrabank agent registration request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: regPath,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator
            def json = response.responseData
            intraAgentWallet = json.accountNo

        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "Intrabank agent registration response: " + new JsonBuilder(response.responseData).toPrettyString()
        return response

    }

    def activateIntraAgent(User user) {
        HttpResponseDecorator response
        def bank = prop.getProperty("intraBank")
        def auth = prop.getProperty("auth")
        def path = ApiPath.regActivationPath

        when:
        def requestBody = [
                agentWalletNo: "",
                bank         : bank,
                userType     : "Agent",
                userWalletNo : intraAgentWallet

        ]
        println "Distributor Activation IB request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "Distributor Activation IB response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def setPINOfIntraAgent(User user) {
        HttpResponseDecorator response
        def bank = prop.getProperty("intraBank")
        def auth = prop.getProperty("auth")
        def pin = prop.getProperty("pin")
        def path = ApiPath.setPINPath

        when:
        def requestBody = [
                walletNumber: intraAgentWallet,
                oldPin      : "",
                newPin      : pin,


        ]
        println "Intra Agent set PIN request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "Intra Agent set PIN response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def ibBankAgentRegistration(User user) {
        def status
        HttpResponseDecorator response
        def bankName = prop.getProperty("ibBank")
        def auth = prop.getProperty("auth")
        def regPath = ApiPath.regPath

        when:
        def requestBody = [
                requestAgent          : "WEB",
                fullName              : "Test Agent TB4",
                email                 : "",
                pin                   : "2468",
                userPin               : "2468",
                userWallet            : "",
                generatedPin          : true,
                userPinEntered        : false,
                hasInitialDeposit     : false,
                registerLogId         : 0,
                userType              : "Agent",
                fatherName            : "",
                motherName            : "",
                birthday              : "",
                gender                : "",
                mobilePhone           : phnNumber4,
                accountNumber         : "",
                occupation            : "",
                addressOffice         : "Banani",
                villageAreaOffice     : "Dhaka",
                psThanaOffice         : "545",
                districtOffice        : "19",
                unionOffice           : "",
                postCodeOffice        : "",
                addressPresent        : "Banani",
                villageAreaPresent    : "Dhaka",
                psThanaPresent        : "538",
                districtPresent       : "19",
                unionPresent          : "",
                postCodePresent       : "",
                addressPermanent      : "",
                villageAreaPermanent  : "",
                psThanaPermanent      : "",
                districtPermanent     : "",
                unionPermanent        : "",
                postCodePermanent     : "",
                nameIntroducer        : "",
                mobileNumberIntroducer: "",
                photographUrl         : "",
                fileUrl               : "",
                fileIdNumber          : "",
                orgAgentAc            : "",
                assignedBank          : "",
                bankName              : bankName,
                branchName            : "",
                status                : "8",
                distributorBankName   : "",
                distributorWallet     : distributorWalletIB,
                srWallet              : "",
                nameOfProprietor      : "",
                businessTerritoryId   : "68",
                businessRegionId      : "15",
                businessAreaId        : "1",
                introducerRelation    : "",
                tradeLicenseNumber    : "",
                tradeLicenseAuthority : "",
                taxId                 : "",
                txnProfileId          : "10",
                alternate_mobile_no   : "",
                nominee_age           : 0,
                merchantWallet        : "",
                disableSMS            : true,
                disableAgentSMS       : true
        ]
        println "IB agent registration request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: regPath,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator
            def json = response.responseData
            ibAgentWallet = json.accountNo

        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "IB agent registration response: " + new JsonBuilder(response.responseData).toPrettyString()
        return response

    }

    def activateIBAgent(User user) {
        HttpResponseDecorator response
        def bank = prop.getProperty("ibBank")
        def auth = prop.getProperty("auth")
        def path = ApiPath.regActivationPath

        when:
        def requestBody = [
                agentWalletNo: "",
                bank         : bank,
                userType     : "Agent",
                userWalletNo : ibAgentWallet

        ]
        println "Agent Activation IB request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "Agent Activation IB response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def setPINOfIBAgent(User user) {
        HttpResponseDecorator response
        def bank = prop.getProperty("ibBank")
        def auth = prop.getProperty("auth")
        def pin = prop.getProperty("pin")
        def path = ApiPath.setPINPath

        when:
        def requestBody = [
                walletNumber: ibAgentWallet,
                oldPin      : "",
                newPin      : pin,


        ]
        println "IB Agent set PIN request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "IB Agent set PIN response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def adAgentRegistration(User user) {
        def status
        HttpResponseDecorator response
        def bankName = prop.getProperty("ibBank")
        def auth = prop.getProperty("auth")
        def regPath = ApiPath.regPath

        when:
        def requestBody = [
                requestAgent          : "WEB",
                fullName              : "Test AD Agent TB4 from TB3",
                email                 : "",
                pin                   : "2468",
                userPin               : "2468",
                userWallet            : "",
                generatedPin          : true,
                userPinEntered        : false,
                hasInitialDeposit     : false,
                registerLogId         : 0,
                userType              : "Agent",
                fatherName            : "",
                motherName            : "",
                birthday              : "",
                gender                : "",
                mobilePhone           : phnNumber5,
                accountNumber         : "",
                occupation            : "",
                addressOffice         : "Banani",
                villageAreaOffice     : "Dhaka",
                psThanaOffice         : "545",
                districtOffice        : "19",
                unionOffice           : "",
                postCodeOffice        : "",
                addressPresent        : "Banani",
                villageAreaPresent    : "Dhaka",
                psThanaPresent        : "538",
                districtPresent       : "19",
                unionPresent          : "",
                postCodePresent       : "",
                addressPermanent      : "",
                villageAreaPermanent  : "",
                psThanaPermanent      : "",
                districtPermanent     : "",
                unionPermanent        : "",
                postCodePermanent     : "",
                nameIntroducer        : "",
                mobileNumberIntroducer: "",
                photographUrl         : "",
                fileUrl               : "",
                fileIdNumber          : "",
                orgAgentAc            : "",
                assignedBank          : "",
                bankName              : bankName,
                branchName            : "",
                status                : "8",
                distributorBankName   : "",
                distributorWallet     : distributorWallet,
                srWallet              : "",
                nameOfProprietor      : "",
                businessTerritoryId   : "68",
                businessRegionId      : "15",
                businessAreaId        : "1",
                introducerRelation    : "",
                tradeLicenseNumber    : "",
                tradeLicenseAuthority : "",
                taxId                 : "",
                txnProfileId          : "10",
                alternate_mobile_no   : "",
                nominee_age           : 0,
                merchantWallet        : "",
                disableSMS            : true,
                disableAgentSMS       : true
        ]
        println "AD agent registration request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: regPath,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator
            def json = response.responseData
            adAgentWallet = json.accountNo

        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "AD agent registration response: " + new JsonBuilder(response.responseData).toPrettyString()
        return response

    }

    def activateADAgent(User user) {
        HttpResponseDecorator response
        def bank = prop.getProperty("ibBank")
        def auth = prop.getProperty("auth")
        def path = ApiPath.regActivationPath

        when:
        def requestBody = [
                agentWalletNo: "",
                bank         : bank,
                userType     : "Agent",
                userWalletNo : adAgentWallet

        ]
        println "AD Agent Activation IB request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "AD Activation IB response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def setPINOfADAgent(User user) {
        HttpResponseDecorator response
        def bank = prop.getProperty("ibBank")
        def auth = prop.getProperty("auth")
        def pin = prop.getProperty("pin")
        def path = ApiPath.setPINPath

        when:
        def requestBody = [
                walletNumber: adAgentWallet,
                oldPin      : "",
                newPin      : pin,


        ]
        println "AD Agent set PIN request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "AD Agent set PIN response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }


    def intraBankCustomer(User user) {
        def status
        HttpResponseDecorator response
        def bankName = prop.getProperty("intraBank")
        def auth = prop.getProperty("auth")
        def regPath = ApiPath.regPath

        when:
        def requestBody = [

                mobilePhone           : phnNumber6,
                fullName              : "Test Customer TB3",
                userWallet            : "",
                agentAc               : intraAgentWallet,
                bankName              : bankName,
                agentBank             : "",
                amount                : 0,
                hasInitialDeposit     : false,
                birthday              : "10/08/1999",
                villageAreaIntroducer : "AAA",
                addressIntroducer     : "AAA",
                districtPermanent     : "19",
                villageAreaOffice     : "",
                psThanaPresent        : "138",
                villageAreaPresent    : "BUET",
                districtPresent       : "19",
                psThanaPermanent      : "138",
                psThanaIntroducer     : "9",
                purposeOfTransaction  : "Personal",
                postCodeOffice        : "",
                userType              : "unbanked",
                accountNumber         : "",
                occupationIntroducer  : "",
                postCodePermanent     : "1206",
                mobileNumberIntroducer: "016314347558",
                gender                : 1,
                postCodeIntroducer    : "",
                districtOffice        : "0",
                postCodePresent       : "1206",
                addressPresent        : "Dhaka",
                fileType              : "National Id",
                occupation            : "Engineer",
                motherName            : "ma",
                psThanaOffice         : "0",
                nameIntroducer        : "",
                addressPermanent      : "",
                fileUrl               : "",
                requestAgent          : "WEB",
                districtIntroducer    : "2",
                photographUrl         : "",
                pin                   : "2468",
                fileIdNumber          : nid1,
                email                 : "sqa@gmail.com",
                addressOffice         : "",
                branchName            : "",
                generatedPin          : true,
                fatherName            : "baba",
                villageAreaPermanent  : "Dhaka",
                disableSMS            : true,
                disableAgentSMS       : true
        ]
        println "Intra Customer registration request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: regPath,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator
            def json = response.responseData
            intraCustomerWallet = json.accountNo

        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "Intra Customer registration response: " + new JsonBuilder(response.responseData).toPrettyString()
        return response

    }

    def activateIntraCustomer(User user) {
        HttpResponseDecorator response
        def bank = prop.getProperty("intraBank")
        def auth = prop.getProperty("auth")
        def path = ApiPath.regActivationPath

        when:
        def requestBody = [
                agentWalletNo: intraAgentWallet,
                bank         : bank,
                userType     : "",
                userWalletNo : intraCustomerWallet

        ]
        println "Intra Customer registration request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "Intra Customer registration response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def setPINOfIntraBankCustomer(User user) {
        HttpResponseDecorator response
        def bank = prop.getProperty("intraBank")
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.setPINPath

        when:
        def requestBody = [
                walletNumber: intraCustomerWallet,
                oldPin      : "",
                newPin      : pin,


        ]
        println "Intra Bank Customer set PIN request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "Intra Bank Customer set PIN response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def ibCustomerRegistration(User user) {
        def status
        HttpResponseDecorator response
        def bankName = prop.getProperty("ibBank")
        def auth = prop.getProperty("auth")
        def regPath = ApiPath.regPath

        when:
        def requestBody = [

                mobilePhone           : phnNumber7,
                fullName              : "Test Customer TB4",
                userWallet            : "",
                agentAc               : ibAgentWallet,
                bankName              : bankName,
                agentBank             : "",
                amount                : 0,
                hasInitialDeposit     : false,
                birthday              : "10/08/1999",
                villageAreaIntroducer : "AAA",
                addressIntroducer     : "AAA",
                districtPermanent     : "19",
                villageAreaOffice     : "",
                psThanaPresent        : "138",
                villageAreaPresent    : "BUET",
                districtPresent       : "19",
                psThanaPermanent      : "138",
                psThanaIntroducer     : "9",
                purposeOfTransaction  : "Personal",
                postCodeOffice        : "",
                userType              : "unbanked",
                accountNumber         : "",
                occupationIntroducer  : "",
                postCodePermanent     : "1206",
                mobileNumberIntroducer: "019074766391",
                gender                : 1,
                postCodeIntroducer    : "",
                districtOffice        : "0",
                postCodePresent       : "1206",
                addressPresent        : "Dhaka",
                fileType              : "National Id",
                occupation            : "Engineer",
                motherName            : "ma",
                psThanaOffice         : "0",
                nameIntroducer        : "",
                addressPermanent      : "",
                fileUrl               : "",
                requestAgent          : "WEB",
                districtIntroducer    : "2",
                photographUrl         : "",
                pin                   : "2468",
                fileIdNumber          : nid2,
                email                 : "sqa@gmail.com",
                addressOffice         : "",
                branchName            : "",
                generatedPin          : true,
                fatherName            : "baba",
                villageAreaPermanent  : "Dhaka",
                disableSMS            : true,
                disableAgentSMS       : true
        ]
        println "IB Customer registration request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: regPath,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator
            def json = response.responseData
            ibCustomerWallet = json.accountNo

        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "IB Customer registration response: " + new JsonBuilder(response.responseData).toPrettyString()
        return response

    }

    def activateIBCustomer(User user) {
        HttpResponseDecorator response
        def bank = prop.getProperty("ibBank")
        def auth = prop.getProperty("auth")
        def path = ApiPath.regActivationPath

        when:
        def requestBody = [
                agentWalletNo: ibAgentWallet,
                bank         : bank,
                userType     : "",
                userWalletNo : ibCustomerWallet

        ]
        println "Intra Customer registration request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "Intra Customer registration response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def setPINOfIBCustomer(User user) {
        HttpResponseDecorator response
        def bank = prop.getProperty("ibBank")
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.setPINPath

        when:
        def requestBody = [
                walletNumber: ibCustomerWallet,
                oldPin      : "",
                newPin      : pin,


        ]
        println "IB Customer set PIN request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "IB Customer set PIN response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def adcCustomerRegistration(User user) {
        def status
        HttpResponseDecorator response
        def bankName = prop.getProperty("ibBank")
        def auth = prop.getProperty("auth")
        def regPath = ApiPath.regPath

        when:
        def requestBody = [

                mobilePhone           : phnNumber8,
                fullName              : "Test Customer TB4 from TB3 Agent",
                userWallet            : "",
                agentAc               : intraAgentWallet,
                bankName              : bankName,
                agentBank             : "",
                amount                : 0,
                hasInitialDeposit     : false,
                birthday              : "10/08/1999",
                villageAreaIntroducer : "AAA",
                addressIntroducer     : "AAA",
                districtPermanent     : "19",
                villageAreaOffice     : "",
                psThanaPresent        : "138",
                villageAreaPresent    : "BUET",
                districtPresent       : "19",
                psThanaPermanent      : "138",
                psThanaIntroducer     : "9",
                purposeOfTransaction  : "Personal",
                postCodeOffice        : "",
                userType              : "unbanked",
                accountNumber         : "",
                occupationIntroducer  : "",
                postCodePermanent     : "1206",
                mobileNumberIntroducer: "",
                gender                : 1,
                postCodeIntroducer    : "",
                districtOffice        : "0",
                postCodePresent       : "1206",
                addressPresent        : "Dhaka",
                fileType              : "National Id",
                occupation            : "Engineer",
                motherName            : "ma",
                psThanaOffice         : "0",
                nameIntroducer        : "",
                addressPermanent      : "",
                fileUrl               : "",
                requestAgent          : "WEB",
                districtIntroducer    : "2",
                photographUrl         : "",
                pin                   : "2468",
                fileIdNumber          : nid3,
                email                 : "sqa@gmail.com",
                addressOffice         : "",
                branchName            : "",
                generatedPin          : true,
                fatherName            : "baba",
                villageAreaPermanent  : "Dhaka",
                disableSMS            : true,
                disableAgentSMS       : true
        ]
        println "ADC Customer registration request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: regPath,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator
            def json = response.responseData
            adcCustomerWallet = json.accountNo

        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "ADC Customer registration response: " + new JsonBuilder(response.responseData).toPrettyString()
        return response

    }

    def activateADCustomer(User user) {
        HttpResponseDecorator response
        def bank = prop.getProperty("ibBank")
        def auth = prop.getProperty("auth")
        def path = ApiPath.regActivationPath

        when:
        def requestBody = [
                agentWalletNo: intraAgentWallet,
                bank         : bank,
                userType     : "",
                userWalletNo : adcCustomerWallet

        ]
        println "ADC Customer registration request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "ADC Customer registration response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def setPINOfADCCustomer(User user) {
        HttpResponseDecorator response
        def bank = prop.getProperty("ibBank")
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.setPINPath

        when:
        def requestBody = [
                walletNumber: adcCustomerWallet,
                oldPin      : "",
                newPin      : pin,


        ]
        println "ADC Customer set PIN request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "ADC Customer set PIN response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def bankCashInToIntraDis(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.pathForSureApi


        when:
        def requestBody = [
                fromAc           : "",
                pin              : pin,
                toAc             : distributorWallet,
                amount           : 100000,
                trnxCode         : "104",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient2.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def bankCashInToIBDis(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.pathForSureApi2


        when:
        def requestBody = [
                fromAc           : "",
                pin              : pin,
                toAc             : distributorWalletIB,
                amount           : 150000,
                trnxCode         : "104",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient2.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def disToIntraAgentCashIn(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath


        when:
        def requestBody = [
                fromAc           : distributorWallet,
                pin              : pin,
                toAc             : intraAgentWallet,
                amount           : 70000,
                trnxCode         : "1203",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }


    def disToIBAgentCashIn(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath


        when:
        def requestBody = [
                fromAc           : distributorWalletIB,
                pin              : pin,
                toAc             : ibAgentWallet,
                amount           : 70000,
                trnxCode         : "1203",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }


    def disToADAgentCashIn(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath


        when:
        def requestBody = [
                fromAc           : distributorWallet,
                pin              : pin,
                toAc             : adAgentWallet,
                amount           : 30000,
                trnxCode         : "1203",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }


    def disToIntraAgentCashOut(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath


        when:
        def requestBody = [
                fromAc           : intraAgentWallet,
                pin              : pin,
                toAc             : distributorWallet,
                amount           : 50,
                trnxCode         : "1204",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }


    def disToIBAgentCashOut(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath


        when:
        def requestBody = [
                fromAc           : ibAgentWallet,
                pin              : pin,
                toAc             : distributorWalletIB,
                amount           : 60,
                trnxCode         : "1204",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }


    def disToADAgentCashOut(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath


        when:
        def requestBody = [
                fromAc           : adAgentWallet,
                pin              : pin,
                toAc             : distributorWallet,
                amount           : 70,
                trnxCode         : "1204",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def intraAgentToIntraCusCashIN(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath


        when:
        def requestBody = [
                fromAc           : intraAgentWallet,
                pin              : pin,
                toAc             : intraCustomerWallet,
                amount           : 25000,
                trnxCode         : "10",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def ibAgentToIntraCusCashIN(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath


        when:
        def requestBody = [
                fromAc           : ibAgentWallet,
                pin              : pin,
                toAc             : intraCustomerWallet,
                amount           : 25000,
                trnxCode         : "10",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def adAgentToIntraCusCashIN(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath


        when:
        def requestBody = [
                fromAc           : adAgentWallet,
                pin              : pin,
                toAc             : intraCustomerWallet,
                amount           : 3000,
                trnxCode         : "10",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def intraAgentToADCCusCashIN(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath


        when:
        def requestBody = [
                fromAc           : intraAgentWallet,
                pin              : pin,
                toAc             : adcCustomerWallet,
                amount           : 3000,
                trnxCode         : "10",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def intraAgentToIntraCusCasOut(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath


        when:
        def requestBody = [
                fromAc           : intraCustomerWallet,
                pin              : pin,
                toAc             : intraAgentWallet,
                amount           : 2500,
                trnxCode         : "11",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def ibAgentToIntraCusCasOut(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath


        when:
        def requestBody = [
                fromAc           : intraCustomerWallet,
                pin              : pin,
                toAc             : ibAgentWallet,
                amount           : 1800,
                trnxCode         : "11",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def adAgentToIntraCusCasOut(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath


        when:
        def requestBody = [
                fromAc           : intraCustomerWallet,
                pin              : pin,
                toAc             : adAgentWallet,
                amount           : 1500,
                trnxCode         : "11",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def intraAgentToADCCusCasOut(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath


        when:
        def requestBody = [
                fromAc           : adcCustomerWallet,
                pin              : pin,
                toAc             : intraAgentWallet,
                amount           : 1500,
                trnxCode         : "11",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def intraCusToIntraCusSendMoney(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def toCusIntra = prop.getProperty("intraCustomer")


        when:
        def requestBody = [
                //fromAc: intraCustomerWallet,
                fromAc           : intraCustomerWallet,
                pin              : pin,
                toAc             : toCusIntra,
                amount           : 20,
                trnxCode         : "1201",
                disableSMSSending: true,
                channel          : "ussd"

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def intraCusToIBCusSendMoney(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def toCusIb = prop.getProperty("ibCustomer")

        when:
        def requestBody = [
                fromAc           : intraCustomerWallet,
                pin              : pin,
                toAc             : toCusIb,
                amount           : 40,
                trnxCode         : "1201",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def intraCusToADCCusSendMoney(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath


        when:
        def requestBody = [
                fromAc           : intraCustomerWallet,
                pin              : pin,
                toAc             : adcCustomerWallet,
                amount           : 20,
                trnxCode         : "1201",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def intraCusToIntraMerchantPayment(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def merchantWallet = prop.getProperty("merchantIntra")


        when:
        def requestBody = [
                fromAc           : intraCustomerWallet,
                pin              : pin,
                toAc             : merchantWallet,
                amount           : 30,
                trnxCode         : "1202",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }
        def json = response.responseData
        intraTxnID = json.trnxId

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()
        println(intraTxnID)

        return response
    }

    def intraCusToIBMerchantPaymentFeeFromCusMinPayment(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def merchantWallet = prop.getProperty("merchantIBFeeFromCus")


        when:
        def requestBody = [
                fromAc           : intraCustomerWallet,
                pin              : pin,
                toAc             : merchantWallet,
                amount           : 35,
                trnxCode         : "1202",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }
        def json = response.responseData
        ibTxnID = json.trnxId[0]

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def intraCusToIBMerchantPaymentFeeFromCusGeneralPayment(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def merchantWallet = prop.getProperty("merchantIBFeeFromCus")


        when:
        def requestBody = [
                fromAc           : intraCustomerWallet,
                pin              : pin,
                toAc             : merchantWallet,
                amount           : 800,
                trnxCode         : "1202",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def intraCusToIBMerchantPaymentFeeFromCusMaxPayment(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def merchantWallet = prop.getProperty("merchantIBFeeFromCus")


        when:
        def requestBody = [
                fromAc           : intraCustomerWallet,
                pin              : pin,
                toAc             : merchantWallet,
                amount           : 3150,
                trnxCode         : "1202",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def intraCusToIBMerchantPaymentFeeFromMerchantMinPayment(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def merchantWallet = prop.getProperty("merchantIBFeeFromMerchant")


        when:
        def requestBody = [
                fromAc           : intraCustomerWallet,
                pin              : pin,
                toAc             : merchantWallet,
                amount           : 40,
                trnxCode         : "1202",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def intraCusToIBMerchantPaymentFeeFromMerchantGeneralPayment(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def merchantWallet = prop.getProperty("merchantIBFeeFromMerchant")


        when:
        def requestBody = [
                fromAc           : intraCustomerWallet,
                pin              : pin,
                toAc             : merchantWallet,
                amount           : 700,
                trnxCode         : "1202",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def intraCusToIBMerchantPaymentFeeFromMerchantMaxPayment(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def merchantWallet = prop.getProperty("merchantIBFeeFromMerchant")


        when:
        def requestBody = [
                fromAc           : intraCustomerWallet,
                pin              : pin,
                toAc             : merchantWallet,
                amount           : 3250,
                trnxCode         : "1202",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def intraAgentToIntraMerchantPayment(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def merchantWallet = prop.getProperty("merchantIntra")


        when:
        def requestBody = [
                fromAc          : intraAgentWallet,
                pin             : pin,
                toAc            : merchantWallet,
                externalCustomer: "01689148320",
                amount          : 25,
                trnxCode        : "107",
                channel         : "ussd"
                //disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def ibAgentToIntraMerchantPayment(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def merchantWallet = prop.getProperty("merchantIntra")


        when:
        def requestBody = [
                fromAc          : ibAgentWallet,
                pin             : pin,
                toAc            : merchantWallet,
                externalCustomer: "01689148320",
                amount          : 50,
                trnxCode        : "107",
                channel         : "ussd"
                //disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def adAgentToIntraMerchantPayment(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def merchantWallet = prop.getProperty("merchantIntra")


        when:
        def requestBody = [
                fromAc          : adAgentWallet,
                pin             : pin,
                toAc            : merchantWallet,
                externalCustomer: "01689148320",
                amount          : 30,
                trnxCode        : "107",
                channel         : "ussd"
                //disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def intraAgentToIBMerchantPaymentFeeFromCustomerMinAmount(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def merchantWallet = prop.getProperty("merchantIBFeeFromCus")


        when:
        def requestBody = [
                fromAc          : intraAgentWallet,
                pin             : pin,
                toAc            : merchantWallet,
                externalCustomer: "01689148320",
                amount          : 55,
                trnxCode        : "107",
                channel         : "ussd"
                //disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def intraAgentToIBMerchantPaymentFeeFromCustomerGeneralAmount(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def merchantWallet = prop.getProperty("merchantIBFeeFromCus")


        when:
        def requestBody = [
                fromAc          : intraAgentWallet,
                pin             : pin,
                toAc            : merchantWallet,
                externalCustomer: "01689148320",
                amount          : 850,
                trnxCode        : "107",
                channel         : "ussd"
                //disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def intraAgentToIBMerchantPaymentFeeFromCustomerMaxAmount(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def merchantWallet = prop.getProperty("merchantIBFeeFromCus")


        when:
        def requestBody = [
                fromAc          : intraAgentWallet,
                pin             : pin,
                toAc            : merchantWallet,
                externalCustomer: "01689148320",
                amount          : 3500,
                trnxCode        : "107",
                channel         : "ussd"
                //disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def ibAgentToIBMerchantPaymentFeeFromCustomer(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def merchantWallet = prop.getProperty("merchantIBFeeFromCus")


        when:
        def requestBody = [
                fromAc          : ibAgentWallet,
                pin             : pin,
                toAc            : merchantWallet,
                externalCustomer: "01689148320",
                amount          : 80,
                trnxCode        : "107",
                channel         : "ussd"
                //disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def adAgentToIBMerchantPaymentFeeFromCustomer(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def merchantWallet = prop.getProperty("merchantIBFeeFromCus")


        when:
        def requestBody = [
                fromAc           : adAgentWallet,
                pin              : pin,
                toAc             : merchantWallet,
                externalCustomer : "01689148320",
                amount           : 600,
                trnxCode         : "107",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def intraAgentToIBMerchantPaymentFeeFromMerchantMinAmount(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def merchantWallet = prop.getProperty("merchantIBFeeFromMerchant")


        when:
        def requestBody = [
                fromAc          : intraAgentWallet,
                pin             : pin,
                toAc            : merchantWallet,
                externalCustomer: "01689148320",
                amount          : 20,
                trnxCode        : "107",
                channel         : "ussd"
                //disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def intraAgentToIBMerchantPaymentFeeFromMerchantGeneralAmount(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def merchantWallet = prop.getProperty("merchantIBFeeFromMerchant")


        when:
        def requestBody = [
                fromAc           : intraAgentWallet,
                pin              : pin,
                toAc             : merchantWallet,
                externalCustomer : "01689148320",
                amount           : 650,
                trnxCode         : "107",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def intraAgentToIBMerchantPaymentFeeFromMerchantMaxAmount(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def merchantWallet = prop.getProperty("merchantIBFeeFromMerchant")


        when:
        def requestBody = [
                fromAc          : intraAgentWallet,
                pin             : pin,
                toAc            : merchantWallet,
                externalCustomer: "01689148320",
                amount          : 3600,
                trnxCode        : "107",
                channel         : "ussd"
                //disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def ibAgentToIBMerchantPaymentFeeFromMerchant(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def merchantWallet = prop.getProperty("merchantIBFeeFromMerchant")


        when:
        def requestBody = [
                fromAc          : ibAgentWallet,
                pin             : pin,
                toAc            : merchantWallet,
                externalCustomer: "01689148320",
                amount          : 100,
                trnxCode        : "107",
                channel         : "ussd"
                //disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def adAgentToIBMerchantPaymentFeeFromMerchant(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def merchantWallet = prop.getProperty("merchantIBFeeFromMerchant")


        when:
        def requestBody = [
                fromAc          : adAgentWallet,
                pin             : pin,
                toAc            : merchantWallet,
                externalCustomer: "01689148320",
                amount          : 600,
                trnxCode        : "107",
                channel         : "ussd"
                //disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def bulkDisburseToIntraCustomer(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.bulkDisbursePath
        def merchantWallet = prop.getProperty("merchantIntra")


        when:
        def requestBody = [
                requests: [
                        [
                                amount            : 1000,
                                fromAc            : merchantWallet,
                                toAc              : intraCustomerWallet,
                                isSingleWithdrawal: false,
                                trnxCode          : 106,
                                pin               :
                                        pin,
                                disbursementRate  : 0,
                                channel           : "WEB",
                                note              : "Intra",
                                withdrawalFeesRate: 1,
                                disableSMSSending : true

                        ]
                ]

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def bulkDisburseToIBCustomer(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.bulkDisbursePath
        def merchantWallet = prop.getProperty("merchantIntra")


        when:
        def requestBody = [
                requests: [
                        [
                                amount            : 1000,
                                fromAc            : merchantWallet,
                                toAc              : ibCustomerWallet,
                                isSingleWithdrawal: false,
                                trnxCode          : 106,
                                pin               : pin,
                                disbursementRate  : 0,
                                channel           : "WEB",
                                note              : "Intra",
                                withdrawalFeesRate: 1,
                                disableSMSSending : true
                        ]

                ]

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def bulkDisburseToADCCustomer(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.bulkDisbursePath
        def merchantWallet = prop.getProperty("merchantIntra")


        when:
        def requestBody = [
                requests: [

                        [amount            : 1000,
                         fromAc            : merchantWallet,
                         toAc              : adcCustomerWallet,
                         isSingleWithdrawal: false,
                         trnxCode          : 106,
                         pin               : pin,
                         disbursementRate  : 0,
                         channel           : "WEB",
                         note              : "Intra",
                         withdrawalFeesRate: 1,
                         disableSMSSending : true

                        ]
                ]

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def bulkCashOutIB(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath


        when:
        def requestBody = [
                fromAc           : ibCustomerWallet,
                pin              : pin,
                toAc             : intraAgentWallet,
                amount           : 500,
                trnxCode         : "11",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def bulkCashOutIntra(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath


        when:
        def requestBody = [
                fromAc           : intraCustomerWallet,
                pin              : pin,
                toAc             : intraAgentWallet,
                amount           : 500,
                trnxCode         : "11",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def doToIntraAgentCashIN(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def doWallet = prop.getProperty("doWallet")
        def agentWallet = prop.getProperty("agentIntraWalletForDO")


        when:
        def requestBody = [
                fromAc           : doWallet,
                pin              : pin,
                toAc             : agentWallet,
                amount           : 40,
                trnxCode         : "1203",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def doToIBAgentCashIN(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def doWallet = prop.getProperty("doWallet")
        def agentWallet = prop.getProperty("agentIBWalletForDO")


        when:
        def requestBody = [
                fromAc           : doWallet,
                pin              : pin,
                toAc             : agentWallet,
                amount           : 40,
                trnxCode         : "1203",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def doToIntraAgentCashOut(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def doWallet = prop.getProperty("doWallet")
        def agentWallet = prop.getProperty("agentIntraWalletForDO")


        when:
        def requestBody = [
                fromAc           : agentWallet,
                pin              : pin,
                toAc             : doWallet,
                amount           : 40,
                trnxCode         : "1204",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def doToIBAgentCashOut(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def doWallet = prop.getProperty("doWallet")
        def agentWallet = prop.getProperty("agentIBWalletForDO")


        when:
        def requestBody = [
                fromAc           : agentWallet,
                pin              : pin,
                toAc             : doWallet,
                amount           : 40,
                trnxCode         : "1204",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def m2mPayment(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def fromMerchant = prop.getProperty("m2mFrom")
        def toMerchant = prop.getProperty("merchantIntra")


        when:
        def requestBody = [
                fromAc           : fromMerchant,
                pin              : pin,
                toAc             : toMerchant,
                amount           : 60,
                trnxCode         : "1601",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def merchantCashOutIntra(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def merchant = prop.getProperty("merchantIntra")


        when:
        def requestBody = [
                fromAc           : merchant,
                pin              : pin,
                toAc             : intraAgentWallet,
                amount           : 70,
                trnxCode         : "1208",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def merchantCashOutIB(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def merchant = prop.getProperty("merchantIntra")


        when:
        def requestBody = [
                fromAc           : merchant,
                pin              : pin,
                toAc             : ibAgentWallet,
                amount           : 80,
                trnxCode         : "1208",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def merchantCashOutADAgent(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def merchant = prop.getProperty("merchantIntra")


        when:
        def requestBody = [
                fromAc           : merchant,
                pin              : pin,
                toAc             : adAgentWallet,
                amount           : 60,
                trnxCode         : "1208",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }


    def stipendRegistration(User user) {
        HttpResponseDecorator response
        def bank = prop.getProperty("intraBank")
        def auth = prop.getProperty("auth")
        def path = ApiPath.stipendRegistration


        when:
        def requestBody = [
                fullName            : "Test Stipend",
                mobilePhone         : phnNumber9,
                bankName            : bank,
                fileIdNumber        : "",
                userWallet          : "",
                pin                 : "1234",
                purposeOfTransaction: "stipend",
                disableSMSSending   : true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'

            ) as HttpResponseDecorator

            //def json=response.responseData
            //stipendCustomer=json.userWallet

        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def activateStipendCus(User user) {
        HttpResponseDecorator response
        def bank = prop.getProperty("intraBank")
        def auth = prop.getProperty("auth")
        def path = ApiPath.regActivationPath

        when:
        def requestBody = [
                agentWalletNo    : "",
                bank             : bank,
                userType         : "unbanked",
                userWalletNo     : stipendCustomer,
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "IB response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def setPINOfStipendCustomer(User user) {
        HttpResponseDecorator response
        def bank = prop.getProperty("intraBank")
        def auth = prop.getProperty("auth")
        def pin = prop.getProperty("pin")
        def path = ApiPath.setPINPath

        when:
        def requestBody = [
                walletNumber: stipendCustomer,
                oldPin      : "",
                newPin      : pin,


        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def stipendDisburse(User user) {
        HttpResponseDecorator response
        def bank = prop.getProperty("intraBank")
        def auth = prop.getProperty("auth")
        def pin = prop.getProperty("pin")
        def path = ApiPath.stipendDisbursePath
        def stipendCus = prop.getProperty("stipendCus")

        when:
        def requestBody = [
                fromAc           : "SYSTEM",
                toAc             : stipendCus,
                amount           : 1000,
                trnxCode         : "106",
                bankName         : bank,
                disableSMSSending: true
        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def stipendCashOutIntra(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def stipendCus = prop.getProperty("stipendCus")


        when:
        def requestBody = [
                fromAc           : stipendCus,
                pin              : pin,
                toAc             : intraAgentWallet,
                amount           : 500,
                trnxCode         : "11",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def stipendCashOutIB(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def stipendCus = prop.getProperty("stipendCus")


        when:
        def requestBody = [
                fromAc           : stipendCus,
                pin              : pin,
                toAc             : ibAgentWallet,
                amount           : 500,
                trnxCode         : "11",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def sugarCustomerWithdrawIntra(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def sugarCus = prop.getProperty("sugarCus")


        when:
        def requestBody = [
                fromAc           : sugarCus,
                pin              : pin,
                toAc             : intraAgentWallet,
                amount           : 200,
                trnxCode         : "11",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def sugarCustomerWithdrawIB(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath
        def sugarCus = prop.getProperty("sugarCus")


        when:
        def requestBody = [
                fromAc           : sugarCus,
                pin              : pin,
                toAc             : ibAgentWallet,
                amount           : 300,
                trnxCode         : "11",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def reversePaymentIntraBank(User user) {
        HttpResponseDecorator response
        def auth = prop.getProperty("auth")
        def pathForTag = ApiPath.reversePaymentPath
        def merchantWallet = prop.getProperty("merchantIntra")


        when:
        def requestBody = [
                txnId : intraTxnID,
                fromAc: intraCustomerWallet,
                toAc  : merchantWallet,
                amount: 30
        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: pathForTag,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }


        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def reversePaymentIB(User user) {
        HttpResponseDecorator response
        def auth = prop.getProperty("auth")
        def pathForTag = ApiPath.reversePaymentPath
        def merchantWallet = prop.getProperty("merchantIBFeeFromCus")


        when:
        def requestBody = [
                txnId : ibTxnID,
                fromAc: intraCustomerWallet,
                toAc  : merchantWallet,
                amount: 30
        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: pathForTag,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }


        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def agentSwapping(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.walletInfoUpdatePath


        when:
        def requestBody = [
                wallet           : intraAgentWallet,
                fieldMapForWallet:
                        [
                                distributorWallet: distributorWalletIB

                        ]

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def changeStatus(User user) {
        HttpResponseDecorator response
        def bank = prop.getProperty("ibBank")
        def auth = prop.getProperty("auth")
        def path = ApiPath.walletInfoUpdatePath


        when:
        def requestBody = [
                wallet           : distributorWalletIB,
                fieldMapForWallet:
                        [
                                "status": "Suspended"
                        ]

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }


    def userGetTypeForIntra(User user) {
        HttpResponseDecorator response
        def bank = prop.getProperty("ibBank")
        def auth = prop.getProperty("auth")
        def pathOfGetType = ApiPath.getUserTypePath
        def getWallet = prop.getProperty("intraCustomer")


        when:
        try {
            response = restClient.get(path: pathOfGetType + getWallet,
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def userGetTypeForIB(User user) {
        HttpResponseDecorator response
        def bank = prop.getProperty("ibBank")
        def auth = prop.getProperty("auth")
        def pathOfGetType = ApiPath.getUserTypePath
        def getWallet = prop.getProperty("ibCustomer")


        when:
        try {
            response = restClient.get(path: pathOfGetType + getWallet,
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def userGetTypeForAdc(User user) {
        HttpResponseDecorator response
        def bank = prop.getProperty("ibBank")
        def auth = prop.getProperty("auth")
        def pathOfGetType = ApiPath.getUserTypePath
        //def getWallet = prop.getProperty("ibCustomer")


        when:
        try {
            response = restClient.get(path: pathOfGetType + adcCustomerWallet,
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def retailerTagAddIntaBank(User user) {
        HttpResponseDecorator response
        def auth = prop.getProperty("auth")
        def pathForTag = ApiPath.retailerTagPath
        def intraCus = prop.getProperty("intraCustomer")


        when:
        def requestBody = [
                wallet      : intraCus,
                purposeOfTxn: "RETAILER",
                "operation" : "ADD"
        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.put(
                    path: pathForTag,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def retailerTagAddIBBank(User user) {
        HttpResponseDecorator response
        def auth = prop.getProperty("auth")
        def pathForTag = ApiPath.retailerTagPath
        def intraCus = prop.getProperty("ibCustomer")


        when:
        def requestBody = [
                wallet      : intraCus,
                purposeOfTxn: "RETAILER",
                "operation" : "ADD"
        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.put(
                    path: pathForTag,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def retailerTagRemoveIntraBank(User user) {
        HttpResponseDecorator response
        def auth = prop.getProperty("auth")
        def pathForTag = ApiPath.retailerTagPath
        def intraCus = prop.getProperty("intraCustomer")


        when:
        def requestBody = [
                wallet      : intraCus,
                purposeOfTxn: "RETAILER",
                "operation" : "REMOVE"
        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.put(
                    path: pathForTag,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def retailerTagRemoveIBBank(User user) {
        HttpResponseDecorator response
        def auth = prop.getProperty("auth")
        def pathForTag = ApiPath.retailerTagPath
        def intraCus = prop.getProperty("ibCustomer")


        when:
        def requestBody = [
                wallet      : intraCus,
                purposeOfTxn: "RETAILER",
                "operation" : "REMOVE"
        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.put(
                    path: pathForTag,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def distGetBalance(User user) {
        def status
        HttpResponseDecorator response
        def getBalancePath = ApiPath.getBalancePath
        def disWalletGetBalance = prop.getProperty("disWalletGetBalance")

        when:

        try {
            response = restClient.get(path: getBalancePath + disWalletGetBalance,
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator
            status = response.status
        } catch (HttpResponseException ex) {
            response = ex.response
        }
        println "Response: " + new JsonBuilder(response.responseData).toPrettyString()
        return response
    }

    def getBalanceWithRightPIN(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.checkBalanceWithPIN


        when:
        def requestBody = [
                userWalletNo: adAgentWallet,
                userType    : "agent",
                pin         : pin
        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }
    }

    def getBalanceWithWrongPIN(User user) {
        HttpResponseDecorator response
        def auth = prop.getProperty("auth")
        def path = ApiPath.checkBalanceWithPIN


        when:
        def requestBody = [
                userWalletNo: adAgentWallet,
                userType    : "agent",
                pin         : "8585"
        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }
    }

    def userCheckCredWithRightPIN(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.checkCredPath


        when:
        def requestBody = [
                walletNumber: intraAgentWallet,
                pin         : pin
        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }


    }

    def userCheckCredWithWrongPIN(User user) {
        HttpResponseDecorator response
        def auth = prop.getProperty("auth")
        def path = ApiPath.checkCredPath


        when:
        def requestBody = [
                walletNumber: intraAgentWallet,
                pin         : "9696"
        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }


    }

    def changePINWithRightPIN(User user) {
        HttpResponseDecorator response
        def bank = prop.getProperty("ibBank")
        def auth = prop.getProperty("auth")
        def pin = prop.getProperty("pin")
        def path = ApiPath.changePINPath

        when:
        def requestBody = [
                walletNumber: intraAgentWallet,
                oldPin      : pin,
                newPin      : "5555",


        ]
        println "IB Distributor set PIN request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "IB Distributor set PIN response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def changePINWithWrongPIN(User user) {
        HttpResponseDecorator response
        def bank = prop.getProperty("ibBank")
        def auth = prop.getProperty("auth")
        def pin = prop.getProperty("pin")
        def path = ApiPath.changePINPath

        when:
        def requestBody = [
                walletNumber: intraAgentWallet,
                oldPin      : pin,
                newPin      : "6666",


        ]
        println "IB Distributor set PIN request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "IB Distributor set PIN response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def txnWithWrongPIN(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath


        when:
        def requestBody = [
                fromAc           : intraAgentWallet,
                pin              : "9696",
                toAc             : intraCustomerWallet,
                amount           : 50,
                trnxCode         : "10",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def enableResetPINMenu(User user) {
        def status
        HttpResponseDecorator response
        def enableResetPIN = ApiPath.enableResetPIN

        when:

        try {
            response = restClient.get(path: enableResetPIN +intraCustomerWallet,
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator
            status = response.status
        } catch (HttpResponseException ex) {
            response = ex.response
        }
        println "Response: " + new JsonBuilder(response.responseData).toPrettyString()
        return response
    }

    def directTopUpWithRobiAirtel(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def bank = prop.getProperty("intraBank")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doTopUp


        when:
        def requestBody = [
                fromAc           : intraCustomerWallet,
                bankName         : bank,
                pin              : pin,
                mobileOperator   : "AIRTEL",
                isPrepaidUser    : true,
                amount           : 50,
                trnxCode         : "1601",
                channel          : "ussd",
                msisdn           : "01689148320"

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def topUpWithOtherOperator(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def bank = prop.getProperty("intraBank")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doTopUp


        when:
        def requestBody = [
                fromAc           : intraCustomerWallet,
                bankName         : bank,
                pin              : pin,
                mobileOperator   : "BANGLALINK",
                isPrepaidUser    : true,
                amount           : 50,
                trnxCode         : "1601",
                channel          : "ussd",
                msisdn           : "01980001673"

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def topUpWithWrongPIN(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def bank = prop.getProperty("intraBank")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doTopUp


        when:
        def requestBody = [
                fromAc           : "016314347517",
                bankName         : bank,
                pin              : "1111",
                mobileOperator   : "AIRTEL",
                isPrepaidUser    : true,
                amount           : 50,
                trnxCode         : "1601",
                channel          : "ussd",
                msisdn           : "01689148320"

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def bankCashOutFromIBDis(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.pathForSureApi2


        when:
        def requestBody = [
                fromAc           : distributorWalletIB,
                pin              : pin,
                toAc             : "",
                amount           : 50,
                trnxCode         : "116",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient2.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def bankCashOutFromIntraDis(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def auth = prop.getProperty("auth")
        def path = ApiPath.pathForSureApi


        when:
        def requestBody = [
                fromAc           : distributorWallet,
                pin              : pin,
                toAc             : "",
                amount           : 60,
                trnxCode         : "116",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient2.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def adAgentToSuspendedIntraCusCashIN(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def suspendedCus = prop.getProperty("suspendedCus")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath


        when:
        def requestBody = [
                fromAc           : adAgentWallet,
                pin              : pin,
                toAc             : suspendedCus,
                amount           : 100,
                trnxCode         : "10",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }

    def adAgentToIntraSuspendedCusCasOut(User user) {
        HttpResponseDecorator response
        def pin = prop.getProperty("pin")
        def suspendedCus = prop.getProperty("suspendedCus")
        def auth = prop.getProperty("auth")
        def path = ApiPath.doPaymentPath


        when:
        def requestBody = [
                fromAc           : suspendedCus,
                pin              : pin,
                toAc             : adAgentWallet,
                amount           : 1500,
                trnxCode         : "11",
                channel          : "ussd",
                disableSMSSending: true

        ]
        println "request: " + new JsonBuilder(requestBody.responseData).toPrettyString()

        try {

            response = restClient.post(
                    path: path,
                    body: requestBody,
                    headers: ['Authorization': auth],
                    requestContentType: 'application/json'
            ) as HttpResponseDecorator


        } catch (HttpResponseException ex) {
            response = ex.response
        }

        println "response: " + new JsonBuilder(response.responseData).toPrettyString()

        return response
    }
}


