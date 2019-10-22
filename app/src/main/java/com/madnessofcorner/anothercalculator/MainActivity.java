package com.madnessofcorner.anothercalculator;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.madnessofcorner.anothercalculator.ui.calculator.CalculatorFragment;
import com.madnessofcorner.anothercalculator.ui.history.HistoryFragment;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

	private AppBarConfiguration mAppBarConfiguration;
	private FragmentTransaction mFragmentTransaction;


	private NavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
			= new NavigationView.OnNavigationItemSelectedListener() {

		@Override
		public boolean onNavigationItemSelected(@NonNull MenuItem item) {
			Fragment fragment = null;
			Log.d("MENU", "itemId2 = " + item.getItemId());
			switch (item.getItemId()) {
				case R.id.nav_pro:
					fragment = new CalculatorFragment();
					return true;
				case R.id.nav_simple:
					fragment = new CalculatorFragment();
					return true;
				case R.id.nav_history:
					fragment = new HistoryFragment();
					return true;
				default: fragment = new CalculatorFragment();
			}
			setFragment(fragment);
			return true;
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		DrawerLayout drawer = findViewById(R.id.drawer_layout);
		NavigationView navigationView = findViewById(R.id.nav_view);
		navigationView.setNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

		// Passing each menu ID as a set of Ids because each
		// menu should be considered as top level destinations.
		mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_pro, R.id.nav_simple, R.id.nav_history)
				.setDrawerLayout(drawer)
				.build();
		NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
		NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
		NavigationUI.setupWithNavController(navigationView, navController);
		navController.navigate(R.id.nav_history);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onSupportNavigateUp() {
		NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
		return NavigationUI.navigateUp(navController, mAppBarConfiguration) || super.onSupportNavigateUp();
	}

	private void setFragment(Fragment fragment){
		mFragmentTransaction = getSupportFragmentManager().beginTransaction();
		mFragmentTransaction.replace(R.id.nav_host_fragment, fragment);
		mFragmentTransaction.commit();
	}
}
