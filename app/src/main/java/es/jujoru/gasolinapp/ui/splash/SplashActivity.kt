package es.jujoru.gasolinapp.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import es.jujoru.gasolinapp.R
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import es.jujoru.gasolinapp.databinding.ActivitySplashBinding
import es.jujoru.gasolinapp.ui.common.BaseActivity
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashActivity : AppCompatActivity(), BaseActivity {
    lateinit var binding: ActivitySplashBinding
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        collectFlows()
        binding.progressBar.visibility = View.VISIBLE
        //viewModel.getFuelStations()
    }

    override fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
    }

    override fun collectFlows() {
        lifecycleScope.launchWhenStarted {

            viewModel.splashUiState.collect{
                 if(it.isLoading){
                     binding.progressBar.visibility = VISIBLE;
                 }else{
                     binding.progressBar.visibility = GONE
                 }
            }
        }
    }
}