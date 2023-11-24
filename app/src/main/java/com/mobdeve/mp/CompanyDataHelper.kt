package com.mobdeve.mp

class CompanyDataHelper {
    companion object{
        fun companyData(jobNames: ArrayList<String>): ArrayList<CompanyPostModel> {
            val data = ArrayList<CompanyPostModel>()
            jobNames.forEach { i ->
                data.add(
                    CompanyPostModel(
                        i.toString()
                    )
                )
            }
            return data
        }
    }

}
