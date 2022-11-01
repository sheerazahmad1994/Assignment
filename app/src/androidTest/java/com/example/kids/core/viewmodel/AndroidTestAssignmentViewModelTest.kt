package com.example.kids.core.viewmodel

import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class AndroidTestAssignmentViewModelTest: TestCase(){

//    private lateinit var viewModel: AndroidTestAssignmentViewModel
//    @get:Rule
//    val instantTaskRule = InstantTaskExecutorRule()
//
//    @Before
//    public override fun setUp() {
//        super.setUp()
//
//        val context = ApplicationProvider.getApplicationContext<Context>()
//        val gson= GsonBuilder().create()
//        val client = OkHttpClient.Builder().build()
//        val retrofit =
//            Retrofit.Builder()
//                .baseUrl(AppConstants.BASE_URL)
//                .client(client)
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .build()
//
//        val apiService : ApiService = retrofit.create(ApiService::class.java)
//        val remoteDataSource = RemoteDataSource(apiService)
//        val repo = AndroidTestAssignmentRepo(remoteDataSource)
//        viewModel = AndroidTestAssignmentViewModel(repo)
//
//    }
//
//    @Test
//    fun testViewModelWithValidData(){
//        var searchWord = "foo"
//        GlobalScope.launch {
//            viewModel.setSearchReference(searchWord)
//        }
//    }
//
//    @Test
//    fun testViewModelWithInValidData(){
//        var searchWord = ""
//        GlobalScope.launch {
//            viewModel.setSearchReference(searchWord)
//        }
//    }


}