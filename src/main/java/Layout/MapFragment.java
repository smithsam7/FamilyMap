package Layout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.FontAwesomeIcons;

import Objects.ClientModel;
import Objects.EventModel;
import academy.learnprogramming.familymap.R;
import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.FontAwesomeIcons;

import static com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_BLUE;
import static com.google.android.gms.maps.model.BitmapDescriptorFactory.defaultMarker;

public class MapFragment extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    private SupportMapFragment mapFragment;
    private TextView personIcon;

    public static MapFragment newInstance(Context in){
        MapFragment fragment = new MapFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View v = layoutInflater.inflate(R.layout.fragment_map_fragment, viewGroup, false);

        mapFragment = (SupportMapFragment)getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        personIcon = v.findViewById(R.id.personIcon);


//        Drawable genderIcon = new IconDrawable(getActivity(), FontAwesomeIcons.fa_male).
//                colorRes(R.color.male_icon).sizeDp(40);
//        genderImageView.setImageDrawable(genderIcon);










        return v;
    }

    @Override
    public void onResume()
    {
        super.onResume();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add all events with a marker
        for (EventModel event : ClientModel.getInstance().getEvents()){
            LatLng latLng = new LatLng(event.getLatitude(), event.getLongitude());
            MarkerOptions options =
                    new MarkerOptions().position(latLng).title(event.getCity())
                            .icon(defaultMarker(HUE_BLUE));
            Marker marker = mMap.addMarker(options);
            marker.setTag(event.getCity());
        }


    }
}
