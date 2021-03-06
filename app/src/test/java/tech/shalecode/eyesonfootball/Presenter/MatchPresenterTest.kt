package tech.shalecode.eyesonfootball.Presenter

import com.nhaarman.mockito_kotlin.doAnswer
import okhttp3.ResponseBody
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import org.mockito.Mock
import com.nhaarman.mockito_kotlin.mock
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.mockito.Mockito.*
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tech.shalecode.eyesonfootball.Server.RetroService
import tech.shalecode.eyesonfootball.Server.ServUtils
import tech.shalecode.eyesonfootball.Utility.OutputServerStats
import tech.shalecode.eyesonfootball.Views.Matchs.MatchActivity

class MatchPresenterTest {

    @Mock
    private
    lateinit var view: MatchActivity

    @Mock
    private
    lateinit var callback: OutputServerStats

    @Mock
    private
    lateinit var retroServ: RetroService

    @Mock
    lateinit var presenter: MatchPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = MatchPresenter(view)
    }

    @Test
    fun getLastMatches() {
        val leagueID = "4328"
        val mockCall: Call<ResponseBody> = mock()
        val bodyResponse: ResponseBody = mock()
        val responseTest = Response.success(bodyResponse)

        GlobalScope.launch {
            `when`(retroServ.getPastMatches(leagueID)).thenReturn(mockCall)
            doAnswer {
                val callBack: Callback<ResponseBody> = it.getArgument(0)
                callBack.onResponse(mockCall, responseTest)
            }.`when`(mockCall).enqueue(any())

            presenter.getLastMatches(leagueID, callback)

            verify(presenter).getLastMatches(leagueID, callback)
            verify(callback).onSuccess(responseTest.body()!!.string())
        }
    }

    @Test
    fun getNextMatch() {
        val leagueID = "4328"
        val mockCall: Call<ResponseBody> = mock()
        val bodyResponse: ResponseBody = mock()
        val responseTest = Response.success(bodyResponse)

        GlobalScope.launch {
            `when`(retroServ.getNextMatches(leagueID)).thenReturn(mockCall)
            doAnswer {
                val callBack: Callback<ResponseBody> = it.getArgument(0)
                callBack.onResponse(mockCall, responseTest)
            }.`when`(mockCall).enqueue(any())

            presenter.getNextMatch(leagueID, callback)

            verify(presenter).getNextMatch(leagueID, callback)
            verify(callback).onSuccess(responseTest.body()!!.string())
        }
    }
}