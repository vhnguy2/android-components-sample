package viet.com.hello;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import viet.com.hello.databinding.CarBinding;

public class CarAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private enum RowType {
    SINGLE, CAROUSEL
  }

  private List<Car> cars;

  public CarAdapter() {
    cars = new ArrayList<>();
  }

  public void setCars(List<Car> cars) {
    this.cars = new ArrayList<>(cars);
    notifyDataSetChanged();
  }

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

    if (viewType == RowType.CAROUSEL.ordinal()) {
      return new CarCarouselVH(
          layoutInflater.inflate(R.layout.car_scroll_list, parent, false)
      );
    } else if (viewType == RowType.SINGLE.ordinal()) {
      return new CarVH(
          CarBinding.inflate(layoutInflater, parent, false)
      );
    }

    return null;
  }

  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    if (holder.getItemViewType() == RowType.CAROUSEL.ordinal()) {
      Car c = cars.get(position);
      List<Car> carList = new ArrayList<>();
      for (int i = 0; i < 5; i++) {
        carList.add(new Car(c.model, c.maker, c.year));
      }
      ((CarCarouselVH) holder).setData(carList);
    } else if (holder.getItemViewType() == RowType.SINGLE.ordinal()) {
      ((CarVH) holder).setData(cars.get(position));
    }
  }

  @Override
  public int getItemCount() {
    return cars.size();
  }

  @Override
  public int getItemViewType(int position) {
    return position % 5 == 0 ? RowType.CAROUSEL.ordinal() : RowType.SINGLE.ordinal();
  }
}
