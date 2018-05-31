package com.anddymao.filterdemo.filter;


import com.anddymao.filterdemo.R;
import com.anddymao.filterdemo.filterlibrary.FilterSDK;

import java.util.ArrayList;

public class FilterFactory {

    public static  ArrayList<FilterItem> getPortraitFilterItem() {
        ArrayList<FilterItem> filters = new ArrayList<FilterItem>();
        filters.add(new FilterItem(null, FilterSDK.sContext.getString(R.string.filter_original), R.drawable.filter_people_original, 0));
        filters.add(new FilterItem(FilterItem.LUT_ADORE, FilterSDK.sContext.getString(R.string.filter_adore), R.drawable.filter_people_nature, 70));
        filters.add(new FilterItem(FilterItem.LUT_AMATORKA, FilterSDK.sContext.getString(R.string.filter_amatorka), R.drawable.filter_people_japanese, 100));
        filters.add(new FilterItem(FilterItem.LUT_FAIRYTALE, FilterSDK.sContext.getString(R.string.filter_fairytale), R.drawable.filter_people_pink, 100));
        filters.add(new FilterItem(FilterItem.LUT_FLOWER, FilterSDK.sContext.getString(R.string.filter_flower), R.drawable.filter_people_story, 100));
        filters.add(new FilterItem(FilterItem.LUT_HEART, FilterSDK.sContext.getString(R.string.filter_heart), R.drawable.filter_people_fairytale, 100));
        filters.add(new FilterItem(FilterItem.LUT_HIGHKEY, FilterSDK.sContext.getString(R.string.filter_highkey), R.drawable.filter_people_roman, 70));
        filters.add(new FilterItem(FilterItem.LUT_PERFUME, FilterSDK.sContext.getString(R.string.filter_perfume), R.drawable.filter_people_heart, 100));
        filters.add(new FilterItem(FilterItem.LUT_PROCESSED, FilterSDK.sContext.getString(R.string.filter_processed), R.drawable.filter_people_maze, 100));
        filters.add(new FilterItem(FilterItem.LUT_RESPONSIBLE, FilterSDK.sContext.getString(R.string.filter_responsible), R.drawable.filter_people_mint, 100));
        return filters;
    }
}
