package viet.com.hello;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import viet.com.hello.databinding.CarCarouselItemBinding;

public class CarCarouselAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private final List<Car> cars;

  public CarCarouselAdapter(List<Car> cars) {
    this.cars = new ArrayList<>(cars);
  }

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    CarCarouselItemBinding binding = CarCarouselItemBinding.inflate(layoutInflater, parent, false);
    return new CarCarouselItemVH(binding);
  }

  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    ((CarCarouselItemVH) holder).bind(cars.get(position));
  }

  @Override
  public int getItemCount() {
    return cars.size();
  }
}
