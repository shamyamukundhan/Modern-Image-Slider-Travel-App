package com.example.travelappconcept;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 locationsViewPager = findViewById(R.id.locationsViewPager);

        List<TravelLocation> travelLocations = new ArrayList<>();

        TravelLocation travelLocationEiffelTower = new TravelLocation();
        travelLocationEiffelTower.title="France";
        travelLocationEiffelTower.location = "Eiffel Tower";
        travelLocationEiffelTower.imageUrl = "https://i1.wp.com/www.likelihoodofconfusion.com/wp-content/uploads/Eiffel-tower.jpg?w=2580&ssl=1";
        travelLocationEiffelTower.starRating = 4.8f;
        travelLocations.add(travelLocationEiffelTower);

        TravelLocation travelLocationMountainView = new TravelLocation();
        travelLocationMountainView.title="Indonesia";
        travelLocationMountainView.location = "Mountain View";
        travelLocationMountainView.imageUrl = "https://jooinn.com/images/mountain-view-51.jpg";
        travelLocationMountainView.starRating = 4.6f;
        travelLocations.add(travelLocationMountainView);

        TravelLocation travelLocationTajMahal = new TravelLocation();
        travelLocationTajMahal.title="India";
        travelLocationTajMahal.location = "Taj Mahal";
        travelLocationTajMahal.imageUrl = "https://i0.wp.com/thepointsguy.com/wp-content/uploads/2019/06/GettyImages-936994634.jpg?fit=2097%2C1430px&ssl=1";
        travelLocationTajMahal.starRating = 4.5f;
        travelLocations.add(travelLocationTajMahal);

        TravelLocation travelLocationLakeView = new TravelLocation();
        travelLocationLakeView.title="Virginia";
        travelLocationLakeView.location = "Lake View";
        travelLocationLakeView.imageUrl = "https://www.wallpaperbetter.com/wallpaper/334/650/359/lake-view-1080P-wallpaper.jpg";
        travelLocationLakeView.starRating = 4.7f;
        travelLocations.add(travelLocationLakeView);

        TravelLocation travelLocationdesertView= new TravelLocation();
        travelLocationdesertView.title="Sahara";
        travelLocationdesertView.location = "Desert view";
        travelLocationdesertView.imageUrl = "https://static.pexels.com/photos/248796/pexels-photo-248796.jpeg";
        travelLocationdesertView.starRating = 4.8f;
        travelLocations.add(travelLocationdesertView);

        locationsViewPager.setAdapter(new TravelLocationAdapter(travelLocations));

        locationsViewPager.setClipToPadding(false);
        locationsViewPager.setClipChildren(false);
        locationsViewPager.setOffscreenPageLimit(3);
        locationsViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1- Math.abs(position);
                page.setScaleY(0.95f + r * 0.05f);


            }
        });

        locationsViewPager.setPageTransformer(compositePageTransformer);

    }
}