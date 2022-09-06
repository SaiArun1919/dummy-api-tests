package com.dummy.api.endpoints.users.get;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

import java.util.List;

@Getter
public class GetUsersListResponse{

	@Setter
	private int statusCode;

	private int total;
	private List<DataItem> data;
	private int limit;
	private int page;

	public boolean hasMrUser(String title){
		boolean mrTitle = data.stream().filter(dataItem -> dataItem.title.equals("mr"))
				.findAny()
				.isPresent();
		return mrTitle;
	}

	public void assertTotalAccountsPresent(){
		Assert.assertEquals(data.size(),total);
	}

	public boolean hasMrsUser(String title){
		boolean mrsTitle = data.stream().filter(dataItem -> dataItem.title.equals("mrs"))
				.findAny()
				.isPresent();
		return mrsTitle;
	}

	@Getter
	public static class DataItem{
		private String firstName;
		private String lastName;
		private String id;
		private String title;
		private String picture;
	}
}