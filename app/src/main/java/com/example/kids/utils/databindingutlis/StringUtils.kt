package com.example.kids.utils.databindingutlis

object StringUtils {

    @JvmStatic
    fun returnSymbolAndPrice(symbol: String, price:String): String {
        return symbol + " " +price
    }

    @JvmStatic
    fun returnFirstNameLastName(fName: String, lName:String): String {
        return fName + " " +lName
    }

    @JvmStatic
    fun returnOrderTitleAndNo( orderNo:String): String {
        return "OrderNo:" + orderNo
    }
    @JvmStatic
    fun returnPaymentMethod( orderNo:String): String {
        return "Payment Type:" + orderNo
    }


}