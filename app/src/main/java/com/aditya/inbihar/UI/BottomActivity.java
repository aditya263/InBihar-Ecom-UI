package com.aditya.inbihar.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.aditya.inbihar.Fragment.HomeFragment;
import com.aditya.inbihar.Fragment.OfferFragment;
import com.aditya.inbihar.Fragment.ProfileFragment;
import com.aditya.inbihar.Model.CurvedBottomNavigationView;
import com.aditya.inbihar.R;
import com.sdsmdg.harjot.vectormaster.VectorMasterView;
import com.sdsmdg.harjot.vectormaster.models.PathModel;

import java.util.Objects;

public class BottomActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    Fragment fragment;
    FragmentTransaction fragmentTransaction;
    CurvedBottomNavigationView bottomNavigationView;
    VectorMasterView fab,fab1,fab2;
    RelativeLayout lin_id;
    PathModel outline;
    TextView titletoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);

        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.toolbar_tiltlebottom);
        View view = getSupportActionBar().getCustomView();

        titletoolbar = view.findViewById(R.id.title);
        //title.setText(titleText);

        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        fab=findViewById(R.id.fab);
        fab1=findViewById(R.id.fab1);
        fab2=findViewById(R.id.fab2);
        lin_id=findViewById(R.id.lin_id);

        bottomNavigationView.inflateMenu(R.menu.main_menu);
        bottomNavigationView.setSelectedItemId(R.id.home);
        //bottomNavigationView.getMenu().getItem(R.id.profile).setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        fragment=new HomeFragment();
        switchFragment(fragment);

    }

    private void switchFragment(Fragment fragment) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frames, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.home:
                fragment=new HomeFragment();
                switchFragment(fragment);
                //animation
                draw(2);
                //find correct path using name
                lin_id.setX(bottomNavigationView.mFirstCurveControlPoint1.x);
                fab.setVisibility(View.VISIBLE);
                fab1.setVisibility(View.GONE);
                fab2.setVisibility(View.GONE);
                drawAnimation(fab);
                break;

            case R.id.profile:
                fragment=new ProfileFragment();
                switchFragment(fragment);
                //animation
                draw();
                //find correct path using name
                lin_id.setX(bottomNavigationView.mFirstCurveControlPoint1.x);
                fab.setVisibility(View.GONE);
                fab1.setVisibility(View.VISIBLE);
                fab2.setVisibility(View.GONE);
                drawAnimation(fab1);
                break;

            case R.id.coupon:
                fragment=new OfferFragment();
                switchFragment(fragment);
                //animation
                draw(6);
                //find correct path using name
                lin_id.setX(bottomNavigationView.mFirstCurveControlPoint1.x);
                fab.setVisibility(View.GONE);
                fab1.setVisibility(View.GONE);
                fab2.setVisibility(View.VISIBLE);
                drawAnimation(fab2);
                break;
        }

        return true;
    }

    private void draw() {
        bottomNavigationView.mFirstCurveStartPoint.set((bottomNavigationView.mNavigationBarWidth*10/12)-
                (bottomNavigationView.CURVE_CIRCLE_RADIUS*2)-
                (bottomNavigationView.CURVE_CIRCLE_RADIUS/15),0);

        bottomNavigationView.mFirstCurveEndPoint.set(bottomNavigationView.mNavigationBarWidth*10/12,bottomNavigationView.CURVE_CIRCLE_RADIUS
                +(bottomNavigationView.CURVE_CIRCLE_RADIUS/4));

        bottomNavigationView.mSecondCurveStartPoint=bottomNavigationView.mFirstCurveEndPoint;
        bottomNavigationView.mSecondCurveEndPoint.set((bottomNavigationView.mNavigationBarWidth*10/12)
                +(bottomNavigationView.CURVE_CIRCLE_RADIUS*2)+(bottomNavigationView.CURVE_CIRCLE_RADIUS/3),0);

        bottomNavigationView.mFirstCurveControlPoint1.set(bottomNavigationView.mFirstCurveStartPoint.x
                        +bottomNavigationView.CURVE_CIRCLE_RADIUS+(bottomNavigationView.CURVE_CIRCLE_RADIUS/4),
                bottomNavigationView.mFirstCurveStartPoint.y);

        bottomNavigationView.mFirstCurveControlPoint2.set(bottomNavigationView.mFirstCurveEndPoint.x-
                        (bottomNavigationView.CURVE_CIRCLE_RADIUS*2)+bottomNavigationView.CURVE_CIRCLE_RADIUS,
                bottomNavigationView.mFirstCurveEndPoint.y);

        //same with second

        bottomNavigationView.mSecondCurveControlPoint1.set(bottomNavigationView.mSecondCurveStartPoint.x
                        +(bottomNavigationView.CURVE_CIRCLE_RADIUS*2)-bottomNavigationView.CURVE_CIRCLE_RADIUS,
                bottomNavigationView.mSecondCurveStartPoint.y);

        bottomNavigationView.mSecondCurveControlPoint2.set(bottomNavigationView.mSecondCurveEndPoint.x-
                (bottomNavigationView.CURVE_CIRCLE_RADIUS+(bottomNavigationView.CURVE_CIRCLE_RADIUS/4)),bottomNavigationView.mSecondCurveEndPoint.y);
    }

    private void drawAnimation(VectorMasterView fab) {
        outline=fab.getPathModelByName("outline");
        outline.setStrokeColor(Color.WHITE);
        outline.setTrimPathEnd(0.0f);

        //Init Animator
        ValueAnimator valueAnimator=ValueAnimator.ofFloat(0.0f,1.0f);
        valueAnimator.setDuration(1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                outline.setTrimPathEnd((Float)valueAnimator.getAnimatedValue());
                fab.update();
            }
        });
        valueAnimator.start();

    }

    private void draw(int i) {
        bottomNavigationView.mFirstCurveStartPoint.set((bottomNavigationView.mNavigationBarWidth/i)
        -(bottomNavigationView.CURVE_CIRCLE_RADIUS*2)-(bottomNavigationView.CURVE_CIRCLE_RADIUS/15),0);

        bottomNavigationView.mFirstCurveEndPoint.set(bottomNavigationView.mNavigationBarWidth/i,bottomNavigationView.CURVE_CIRCLE_RADIUS
        +(bottomNavigationView.CURVE_CIRCLE_RADIUS/4));

        bottomNavigationView.mSecondCurveStartPoint=bottomNavigationView.mFirstCurveEndPoint;
        bottomNavigationView.mSecondCurveEndPoint.set((bottomNavigationView.mNavigationBarWidth/i)
        +(bottomNavigationView.CURVE_CIRCLE_RADIUS*2)+(bottomNavigationView.CURVE_CIRCLE_RADIUS/3),0);

        bottomNavigationView.mFirstCurveControlPoint1.set(bottomNavigationView.mFirstCurveStartPoint.x
        +bottomNavigationView.CURVE_CIRCLE_RADIUS+(bottomNavigationView.CURVE_CIRCLE_RADIUS/4),
                bottomNavigationView.mFirstCurveStartPoint.y);

        bottomNavigationView.mFirstCurveControlPoint2.set(bottomNavigationView.mFirstCurveEndPoint.x-
                (bottomNavigationView.CURVE_CIRCLE_RADIUS*2)+bottomNavigationView.CURVE_CIRCLE_RADIUS,
                bottomNavigationView.mFirstCurveEndPoint.y);

        //same with second

        bottomNavigationView.mSecondCurveControlPoint1.set(bottomNavigationView.mSecondCurveStartPoint.x
                        +(bottomNavigationView.CURVE_CIRCLE_RADIUS*2)-bottomNavigationView.CURVE_CIRCLE_RADIUS,
                bottomNavigationView.mSecondCurveStartPoint.y);

        bottomNavigationView.mSecondCurveControlPoint2.set(bottomNavigationView.mSecondCurveEndPoint.x-
                (bottomNavigationView.CURVE_CIRCLE_RADIUS+(bottomNavigationView.CURVE_CIRCLE_RADIUS/4)),bottomNavigationView.mSecondCurveEndPoint.y);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void setActionBarTitle(String title) {
        titletoolbar.setText(title);
        //getSupportActionBar().setTitle(title);
    }
}