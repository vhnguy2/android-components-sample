package viet.com.hello;

import android.support.v7.widget.RecyclerView;

import viet.com.hello.databinding.CarCarouselItemBinding;

public class CarCarouselItemVH extends RecyclerView.ViewHolder {

  private final CarCarouselItemBinding binding;

  public CarCarouselItemVH(CarCarouselItemBinding binding) {
    super(binding.getRoot());
    this.binding = binding;
  }

  public void bind(Car car) {
    binding.setCar(car);
  }
}
