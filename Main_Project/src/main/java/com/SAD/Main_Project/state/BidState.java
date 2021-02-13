package com.SAD.Main_Project.state;

public class BidState implements PostState {

    @Override
    public void upComingPost() {
        System.out.println("Products before bid will be shown");
    }

    @Override
    public void onGoingPost() {
        System.out.println("Bid Product are shown for bidding");
    }

    @Override
    public void completedPost() {
        System.out.println("Products not shown after bid time over");
    }

}
