package com.example.kavakexam.view.friends.repository
import android.content.Context
import android.net.ConnectivityManager
import com.example.kavakexam.dto.friends.behavior.Friends
import com.example.kavakexam.dto.friends.behavior.FriendsServices
import com.example.kavakexam.dto.friends.pojo.FriendsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FriendsRepository(
    val friendsServices: FriendsServices,
    val context: Context) : Friends.Repository {

    override fun getFriends(callback: Friends.CallBackServices) {
        val call : Call<FriendsResponse> = friendsServices.getAllTypeCoin()
        call.enqueue(object : Callback<FriendsResponse> {
            override fun onResponse(
                call: Call<FriendsResponse>,
                response: Response<FriendsResponse>
            ) {
                callback.onCompletedCall(response.body());
            }
            override fun onFailure(call: Call<FriendsResponse>, t: Throwable) {
                callback.onCompletedCall(t);
            }
        } )
    }


    override fun availableNetwork() : Boolean{
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return  networkInfo!=null && networkInfo.isConnected
    }
}