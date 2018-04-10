package viet.com.hello;

import android.support.v7.widget.RecyclerView;

import viet.com.hello.databinding.CarBinding;

public class CarVH extends RecyclerView.ViewHolder {

  private final CarBinding carBinding;

  public CarVH(CarBinding carBinding) {
    super(carBinding.getRoot());
    this.carBinding = carBinding;
  }

  public void setData(Car car) {
    carBinding.setCar(car);
  }
}
