package viet.com.hello;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MainFragment extends Fragment {

  private RecyclerView recyclerView;
  private MyViewModel myFragmentViewModel;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater,
                           ViewGroup container,
                           Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.main_fragment, container, false);
    recyclerView = v.findViewById(R.id.main_list);
    setupList(getActivity());
    return v;
  }

  private void setupList(Context context) {
    loadData();
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    final CarAdapter adapter = new CarAdapter();
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(linearLayoutManager);
    recyclerView.setHasFixedSize(true);

    myFragmentViewModel.getCars().observe(this, new Observer<List<Car>>() {
      @Override
      public void onChanged(@Nullable List<Car> cars) {
        if (cars == null) {
          return;
        }
        // update the adapter
        adapter.setCars(cars);
      }
    });
  }

  private void loadData() {
    if (myFragmentViewModel != null) {
      return;
    }

    myFragmentViewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);

  }

  public static MainFragment newInstance() {
    MainFragment fragment = new MainFragment();
    Bundle args = new Bundle();
    fragment.setArguments(args);
    return fragment;
  }
}
