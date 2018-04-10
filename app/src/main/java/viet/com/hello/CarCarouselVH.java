package viet.com.hello;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

public class CarCarouselVH extends RecyclerView.ViewHolder {

  private final RecyclerView recyclerView;

  public CarCarouselVH(View itemView) {
    super(itemView);
    recyclerView = itemView.findViewById(R.id.car_scroll_list);
  }

  public void setData(List<Car> cars) {
    recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.HORIZONTAL, false));
    recyclerView.setAdapter(new CarCarouselAdapter(cars));
  }
}
