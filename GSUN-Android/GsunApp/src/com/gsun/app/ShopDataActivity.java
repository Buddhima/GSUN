package com.gsun.app;

import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;

import com.gsun.objects.Shop;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

public class ShopDataActivity extends Activity {

	public static Shop selectedShop;

	ExpandableListView expandableList;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.shopdata);

		expandableList = (ExpandableListView) findViewById(R.id.expandableListView1);

		TextView companyName = (TextView) findViewById(R.id.shop_data_name);

		companyName.setText(selectedShop.getShop_name());

		SimpleExpandableListAdapter expListAdapter = new SimpleExpandableListAdapter(
				this,

				createMainList(), R.layout.group_row,
				new String[] { "Group Item" }, new int[] { R.id.row_name },

				createSubLists(), R.layout.child_row,
				new String[] { "Sub Item_1" }, new int[] { R.id.grp_child1 }

		);

		expandableList.setAdapter(expListAdapter);

		expandableList.setIndicatorBounds(380, 390);

		expandableList.setOnChildClickListener(new OnChildClickListener() {
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {

				if (groupPosition == 1 && childPosition == 0) {

					Uri uri = Uri.parse("tel:" + selectedShop.getTelephone_no());
					Intent in = new Intent(Intent.ACTION_VIEW, uri);
					startActivity(in);

				} // want to call

				if (groupPosition == 1 && childPosition == 1) {

					Intent i = new Intent(Intent.ACTION_SEND);
					i.putExtra(android.content.Intent.EXTRA_EMAIL,
							new String[] { selectedShop.getEmail() });
					// i.putExtra(android.content.Intent.EXTRA_SUBJECT,
					// "hello");
					// i.putExtra(android.content.Intent.EXTRA_TEXT, "FFF");
					
					i.setType("text/plain");
					startActivity(Intent.createChooser(i, "Send email"));

				} // want to email

				return true;
			}
		});

		TextView map = (TextView) findViewById(R.id.MapTextItem);

		map.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent myIntent = new Intent(v.getContext(),
						ShopMapActivity.class);
				startActivity(myIntent);

			}
		});

	}

	private List createMainList() {

		ArrayList mainList = new ArrayList();

		HashMap m1 = new HashMap();
		m1.put("Group Item", "Details");
		HashMap m2 = new HashMap();
		m2.put("Group Item", "Contact");

		mainList.add(m1);
		mainList.add(m2);

		return (List) mainList;
	}

	private List createSubLists() {

		ArrayList submenuCollection = new ArrayList();

		ArrayList submenuDetail = new ArrayList();
		// submenuDetail.add("Shop name");submenuDetail.add("Shop Type");submenuDetail.add("Shop Address");
		HashMap m1 = new HashMap();
		m1.put("Sub Item_1", "Shop name: " + selectedShop.getShop_name());
		HashMap m2 = new HashMap();
		m2.put("Sub Item_1", "Shop Type: "+selectedShop.getDiscription());
		HashMap m3 = new HashMap();
		m3.put("Sub Item_1", "Shop Address: " + selectedShop.getAddress());

		submenuDetail.add(m1);
		submenuDetail.add(m2);
		submenuDetail.add(m3);

		submenuCollection.add(submenuDetail);

		ArrayList submenuContact = new ArrayList();
		// submenuContact.add("Telephone No:"); submenuContact.add("Email");
		HashMap m4 = new HashMap();
		m4.put("Sub Item_1", "Telephone No: " + selectedShop.getTelephone_no());
		HashMap m5 = new HashMap();
		m5.put("Sub Item_1", "Email: " + selectedShop.getEmail());

		submenuContact.add(m4);
		submenuContact.add(m5);

		submenuCollection.add(submenuContact);

		return (List) submenuCollection;

	}

}
