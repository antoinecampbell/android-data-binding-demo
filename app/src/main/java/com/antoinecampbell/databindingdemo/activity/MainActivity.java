package com.antoinecampbell.databindingdemo.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.antoinecampbell.databindingdemo.R;
import com.antoinecampbell.databindingdemo.fragment.RecyclerViewFragment;
import com.antoinecampbell.databindingdemo.fragment.RecyclerViewTwoWayFragment;
import com.antoinecampbell.databindingdemo.fragment.SimpleBindingFragment;
import com.antoinecampbell.databindingdemo.fragment.SimpleBindingTwoWayFragment;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ListView drawerListView;
    ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup action bar if present
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);

            // Initialize drawer items
            drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawerListView = (ListView) findViewById(R.id.listview);

            // Drawer list
            String[] items = new String[]{
                    "Simple Data Binding (one way)",
                    "Simple Data Binding (two way)",
                    "RecyclerView Data Binding (one-way)",
                    "RecyclerView Data Binding (two-way)"
            };
            drawerListView.setAdapter(
                    new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));

            // Handle drawer item clicks
            drawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Fragment fragment = null;
                    switch (position) {
                        case 0:
                            fragment = SimpleBindingFragment.newInstance();
                            break;
                        case 1:
                            fragment = SimpleBindingTwoWayFragment.newInstance();
                            break;
                        case 2:
                            fragment = RecyclerViewFragment.newInstance();
                            break;
                        case 3:
                            fragment = RecyclerViewTwoWayFragment.newInstance();
                            break;
                        default:
                            break;
                    }
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, fragment).commit();
                    // Close drawer
                    drawerLayout.closeDrawer(drawerListView);
                }
            });

            // Initialize drawer toggle
            drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                    R.string.drawer_open, R.string.drawer_close);
            drawerLayout.setDrawerListener(drawerToggle);
        }

        // Set initial fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    SimpleBindingFragment.newInstance()).commit();
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        return drawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}
