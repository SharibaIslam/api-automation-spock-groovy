package api

class ApiPath {
    //staging
    public static final String hostURL="http://192.168.168.43:7070"
    public static final String hostURL2="http://192.168.168.150:8080"
    public static final String regPath="/proSw/rest/apiv2/switch/register"
    public static final String regActivationPath="/proSw/rest/apiv2/switch/activate/user"
    public static final String setPINPath="/proSw/rest/apiv2/switch/direct/reset/pin"
    //staging
    public static final String pathForSureApi="/surecash_tb3/v1/api/do/payment"
    public static final String pathForSureApi2="/surecash_tb4/v1/api/do/payment"
    public static final String doPaymentPath="/proSw/rest/apiv2/switch/do/payment"
    public static final String bulkDisbursePath="/proSw/rest/apiv2/switch/do/bulk/payment"
    public static final String walletInfoUpdatePath="/proSw/rest/apiv2/switch/update/walletInfo"
    public static final String stipendRegistration="/proSw/rest/apiv2/switch/do/stipend/register"
    public static final String stipendDisbursePath="/proSw/rest/apiv2/switch/do/singleTxn"
    public static final String getUserTypePath="/proSw/rest/apiv2/switch/get/type/"
    public static final String retailerTagPath="/proSw/rest/apiv3/switch/wallet/update/tag"
    public static final String addFavPayee="/api/customer/update/merchant/customer"
    public static final String deleteFavPayee="/api/customer/remove/merchant/customer"
    public static final String sendMoney="/api/txn/send/money"
    public static final String reversePaymentPath="/proSw/rest/apiv2/switch/do/reverseTxn"
    public static final String getBalancePath="/proSw/rest/apiv2/switch/get/balance/"
    public static final String checkCredPath="/proSw/rest/apiv2/switch/check/cred"
    public static final String checkBalanceWithPIN="/proSw/rest/apiv2/switch/balance"
    public static final String changePINPath="/proSw/rest/apiv2/switch/change/pin"
    public static final String enableResetPIN="/proSw/rest/apiv2/switch/update/isSetPin/flag/"
    public static final String doTopUp="/proSw/rest/apiv2/switch/do/topup"


}
