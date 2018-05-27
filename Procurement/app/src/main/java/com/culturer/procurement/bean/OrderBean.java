package com.culturer.procurement.bean;


import java.util.List;

public class OrderBean {
	
	/**
	 * confirmOrder : {"ModProducts":[{"Id":5,"SortId":0,"UserId":1,"ProductTypeId":3,"PartnerId":0,"Name":"%E9%BE%99%E8%99%BE","Count":45,"Price":20,"StandardPrice":1,"Desc":"%E5%B9%BF%E6%B3%9B%E5%A4%A7%E6%A6%82","Msg":"%E5%A5%BD%E5%90%83%E7%9A%84%E9%BE%99%E8%99%BE","CreateTime":"2018-04-28 20:19:15","CoverUrl":"","BuyNum":2,"SumPrice":40,"IsCarousel":1,"IsHot":0},{"Id":7,"SortId":0,"UserId":1,"ProductTypeId":3,"PartnerId":0,"Name":"%E5%95%86%E5%93%81%E6%B5%8B%E8%AF%953","Count":66,"Price":34,"StandardPrice":56,"Desc":"%3Cdiv%20class%3D%22dict_banner%22%20style%3D%22margin-bottom%3A%2020px%3B%20color%3A%20rgb(102%2C%20102%2C%20102)%3B%20font-family%3A%20%26quot%3BMicrosoft%20YaHei%26quot%3B%2C%20%E5%AE%8B%E4%BD%93%3B%20font-size%3A%2013px%3B%22%3E%3Ca%20id%3D%22ads_banner%22%20target%3D%22_blank%22%20href%3D%22https%3A%2F%2Fbingdict.chinacloudsites.cn%2Fdownload%3Ftag%3DBDPDV%22%20h%3D%22ID%3DDictionary%2C5090.1%22%20style%3D%22color%3A%20rgb(96%2C%200%2C%20144)%3B%22%3E%3Cimg%20width%3D%22718%22%20height%3D%2268%22%20class%3D%22rms_img%22%20src%3D%22https%3A%2F%2Fcn.bing.com%2Fth%3Fid%3DOJ.2Eh3yWRgmXNSkA%26amp%3Bpid%3DMSNJVFeeds%22%20data-bm%3D%227%22%20style%3D%22border-collapse%3A%20collapse%3B%20border-spacing%3A%200px%3B%20list-style%3A%20none%3B%20margin%3A%200px%3B%20padding%3A%200px%3B%22%3E%3C%2Fa%3E%3C%2Fdiv%3E%3Cdiv%20class%3D%22client_homepage_leftside_area%22%20style%3D%22width%3A%20273px%3B%20float%3A%20left%3B%20overflow%3A%20hidden%3B%20margin-right%3A%2015px%3B%20color%3A%20rgb(102%2C%20102%2C%20102)%3B%20font-family%3A%20%26quot%3BMicrosoft%20YaHei%26quot%3B%2C%20%E5%AE%8B%E4%BD%93%3B%20font-size%3A%2013px%3B%22%3E%3Cdiv%20class%3D%22client_daily_words_panel%22%3E%3Cdiv%20class%3D%22client_daily_word_title%20hp_title%22%20style%3D%22font-size%3A%2016px%3B%20font-weight%3A%20bold%3B%20margin-bottom%3A%2015px%3B%20width%3A%20273px%3B%20overflow%3A%20hidden%3B%20height%3A%2020px%3B%22%3E%E6%AF%8F%E6%97%A5%E8%AF%8D%E6%B1%87%3C%2Fdiv%3E%3Cdiv%20class%3D%22client_daily_word_content%22%20style%3D%22background-color%3A%20rgb(240%2C%20240%2C%20240)%3B%20padding%3A%2015px%3B%20height%3A%20270px%3B%22%3E%3Cdiv%20class%3D%22client_daily_words_bar%22%20style%3D%22overflow%3A%20hidden%3B%22%3E%3Cdiv%20class%3D%22client_daily_word_en%22%20style%3D%22overflow%3A%20hidden%3B%20padding-bottom%3A%2010px%3B%20font-size%3A%2026px%3B%22%3E%3Ca%20href%3D%22https%3A%2F%2Fcn.bing.com%2Fdict%2Fsearch%3Fq%3Dmigrate%26amp%3BFORM%3DBDVSP6%26amp%3Bmkt%3Dzh-cn%22%20h%3D%22ID%3DDictionary%2C5092.1%22%20style%3D%22color%3A%20rgb(96%2C%200%2C%20144)%3B%22%3Emigrate%3C%2Fa%3E%3C%2Fdiv%3E%3Cdiv%20class%3D%22client_daily_word_pn%22%20style%3D%22overflow%3A%20hidden%3B%20width%3A%20243px%3B%22%3E%3Cdiv%20class%3D%22client_daily_word_pn_pn%22%20lang%3D%22en%22%20style%3D%22float%3A%20left%3B%20font-size%3A%2014px%3B%20margin%3A%200px%200px%205px%3B%20line-height%3A%2020px%3B%22%3E%E7%BE%8E%5B'ma%C9%AA.%C9%A1re%C9%AAt%5D%3C%2Fdiv%3E%3Cdiv%20class%3D%22client_daily_word_pn_audio%22%20style%3D%22float%3A%20left%3B%20padding-left%3A%2010px%3B%22%3E%3Cdiv%20class%3D%22client_icon_container%22%20style%3D%22width%3A%2024px%3B%20height%3A%2024px%3B%20overflow%3A%20hidden%3B%20cursor%3A%20pointer%3B%22%3E%3Ca%20class%3D%22client_aud_o%22%20title%3D%22%E7%82%B9%E5%87%BB%E6%9C%97%E8%AF%BB%22%20h%3D%22ID%3DDictionary%2C5093.1%22%20style%3D%22color%3A%20rgb(96%2C%200%2C%20144)%3B%20display%3A%20block%3B%20width%3A%2024px%3B%20height%3A%2024px%3B%20background-image%3A%20url(%26quot%3B%2Fs%2Fdictionary%2Fspeaker_normal.png%26quot%3B)%3B%20background-repeat%3A%20no-repeat%3B%22%3E%3C%2Fa%3E%3C%2Fdiv%3E%3C%2Fdiv%3E%3C%2Fdiv%3E%3Cdiv%20class%3D%22client_daily_word_pn%22%20style%3D%22overflow%3A%20hidden%3B%20width%3A%20243px%3B%22%3E%3Cdiv%20class%3D%22client_daily_word_pn_pn%22%20lang%3D%22en%22%20style%3D%22float%3A%20left%3B%20font-size%3A%2014px%3B%20margin%3A%200px%200px%205px%3B%20line-height%3A%2020px%3B%22%3E%E8%8B%B1%5Bma%C9%AA'%C9%A1re%C9%AAt%5D%3C%2Fdiv%3E%3Cdiv%20class%3D%22client_daily_word_pn_audio%22%20style%3D%22float%3A%20left%3B%20padding-left%3A%2010px%3B%22%3E%3Cdiv%20class%3D%22client_icon_container%22%20style%3D%22width%3A%2024px%3B%20height%3A%2024px%3B%20overflow%3A%20hidden%3B%20cursor%3A%20pointer%3B%22%3E%3Ca%20class%3D%22client_aud_o%22%20title%3D%22%E7%82%B9%E5%87%BB%E6%9C%97%E8%AF%BB%22%20h%3D%22ID%3DDictionary%2C5094.1%22%20style%3D%22color%3A%20rgb(96%2C%200%2C%20144)%3B%20display%3A%20block%3B%20width%3A%2024px%3B%20height%3A%2024px%3B%20background-image%3A%20url(%26quot%3B%2Fs%2Fdictionary%2Fspeaker_normal.png%26quot%3B)%3B%20background-repeat%3A%20no-repeat%3B%22%3E%3C%2Fa%3E%3C%2Fdiv%3E%3C%2Fdiv%3E%3C%2Fdiv%3E%3Cdiv%20class%3D%22client_daily_word_zh%22%20style%3D%22overflow%3A%20hidden%3B%20padding-top%3A%205px%3B%20padding-bottom%3A%2015px%3B%20font-size%3A%2020px%3B%22%3Ev.%20%E8%BF%81%E7%A7%BB%EF%BC%9B%E7%A7%BB%E5%B1%85%3C%2Fdiv%3E%3C%2Fdiv%3E%3Cdiv%20class%3D%22client_daily_pic_bar%22%20style%3D%22overflow%3A%20hidden%3B%20width%3A%20243px%3B%22%3E%3Ca%20target%3D%22_blank%22%20class%3D%22client_daily_pic_item%22%20href%3D%22https%3A%2F%2Fcn.bing.com%2Fimages%2Fsearch%3Fq%3Dmigrate%26amp%3BFORM%3DBDCN14%26amp%3Bmkt%3Dzh-cn%22%20h%3D%22ID%3DDictionary%2C5095.1%22%20style%3D%22color%3A%20rgb(96%2C%200%2C%20144)%3B%20float%3A%20left%3B%20width%3A%2080px%3B%20height%3A%2080px%3B%20margin-right%3A%201px%3B%22%3E%3Cimg%20height%3D%2280%22%20width%3D%2280%22%20id%3D%22emb46A7C326%22%20class%3D%22rms_img%22%20src%3D%22https%3A%2F%2Fwordchallenge.blob.core.windows.net%2Fdicthpimage%2Fmigrate_1.jpg%22%20data-bm%3D%228%22%20style%3D%22border-collapse%3A%20collapse%3B%20border-spacing%3A%200px%3B%20list-style%3A%20none%3B%20margin%3A%200px%3B%20padding%3A%200px%3B%22%3E%3C%2Fa%3E%3Ca%20target%3D%22_blank%22%20class%3D%22client_daily_pic_item%22%20href%3D%22https%3A%2F%2Fcn.bing.com%2Fimages%2Fsearch%3Fq%3Dmigrate%26amp%3BFORM%3DBDCN14%26amp%3Bmkt%3Dzh-cn%22%20h%3D%22ID%3DDictionary%2C5095.2%22%20style%3D%22color%3A%20rgb(96%2C%200%2C%20144)%3B%20float%3A%20left%3B%20width%3A%2080px%3B%20height%3A%2080px%3B%20margin-right%3A%201px%3B%22%3E%3Cimg%20height%3D%2280%22%20width%3D%2280%22%20id%3D%22emb15FFA1156%22%20class%3D%22rms_img%22%20src%3D%22https%3A%2F%2Fwordchallenge.blob.core.windows.net%2Fdicthpimage%2Fmigrate_2.jpg%22%20data-bm%3D%229%22%20style%3D%22border-collapse%3A%20collapse%3B%20border-spacing%3A%200px%3B%20list-style%3A%20none%3B%20margin%3A%200px%3B%20padding%3A%200px%3B%22%3E%3C%2Fa%3E%3Ca%20target%3D%22_blank%22%20class%3D%22client_daily_pic_item%22%20href%3D%22https%3A%2F%2Fcn.bing.com%2Fimages%2Fsearch%3Fq%3Dmigrate%26amp%3BFORM%3DBDCN14%26amp%3Bmkt%3Dzh-cn%22%20h%3D%22ID%3DDictionary%2C5095.3%22%20style%3D%22color%3A%20rgb(96%2C%200%2C%20144)%3B%20float%3A%20left%3B%20width%3A%2080px%3B%20height%3A%2080px%3B%20margin-right%3A%201px%3B%22%3E%3Cimg%20height%3D%2280%22%20width%3D%2280%22%20id%3D%22emb26360BEA9%22%20class%3D%22rms_img%22%20src%3D%22https%3A%2F%2Fwordchallenge.blob.core.windows.net%2Fdicthpimage%2Fmigrate_3.jpg%22%20data-bm%3D%2210%22%20style%3D%22border-collapse%3A%20collapse%3B%20border-spacing%3A%200px%3B%20list-style%3A%20none%3B%20margin%3A%200px%3B%20padding%3A%200px%3B%22%3E%3C%2Fa%3E%3C%2Fdiv%3E%3Cdiv%20id%3D%22shareview%22%20class%3D%22client_share_bar%22%20style%3D%22margin-top%3A%2015px%3B%20padding-top%3A%205px%3B%20height%3A%2020px%3B%22%3E%3Cdiv%20class%3D%22shareText%22%20style%3D%22float%3A%20left%3B%20margin%3A%200px%2010px%200px%200px%3B%22%3E%E5%85%B1%E4%BA%AB%E5%88%B0%3A%3C%2Fdiv%3E%3C%2Fdiv%3E%3C%2Fdiv%3E%3C%2Fdiv%3E%3C%2Fdiv%3E%0A%20%20%20%20%20%20%20%20","Msg":"%E5%8D%9A%E6%A0%BC%E5%8D%8E%E7%BA%B3%E5%A5%BD%E4%B9%85%E6%B2%A1","CreateTime":"2018-05-03 10:46:28","CoverUrl":"","BuyNum":3,"SumPrice":102,"IsCarousel":0,"IsHot":0}],"TmpOrder":{"Id":0,"OrderNum":"U13T1526880784136","SortId":0,"UserId":13,"AddressId":0,"Address":"%E5%9B%9B%E5%B7%9D%E7%9C%81%E6%88%90%E9%83%BD%E5%B8%82%E6%AD%A6%E4%BE%AF%E5%8C%BA%E6%AD%A6%E4%BE%AF%E7%A5%A0%E5%A4%A7%E8%A1%97264%E5%8F%B7","Receiver":"","Phone":"","Position":"{\"latitude\":30.64242,\"longitude\":104.04311}","TranslateStatus":"","PayType":"","RealPrice":0,"ShouldPrice":142,"PriceMsg":"","PartnerId":0,"CreateTime":"2018-05-21 13:33:04","OrderStatus":0,"IsPay":false,"IsDlivery":false,"IsSign":false,"IsCash":false,"IsComment":false,"IsCancel":false,"Remark":"%E5%B9%85%E5%BA%A6%E8%90%A8%E8%8A%AC%E7%9A%84","Comments":"","CancelComments":""}}
	 * status : 200
	 * time : 2018-05-21 13:33:04
	 */
	
	private ConfirmOrderBean confirmOrder;
	private int status;
	private String time;
	
	public ConfirmOrderBean getConfirmOrder() {
		return confirmOrder;
	}
	
	public void setConfirmOrder(ConfirmOrderBean confirmOrder) {
		this.confirmOrder = confirmOrder;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public static class ConfirmOrderBean {
		/**
		 * ModProducts : [{"Id":5,"SortId":0,"UserId":1,"ProductTypeId":3,"PartnerId":0,"Name":"%E9%BE%99%E8%99%BE","Count":45,"Price":20,"StandardPrice":1,"Desc":"%E5%B9%BF%E6%B3%9B%E5%A4%A7%E6%A6%82","Msg":"%E5%A5%BD%E5%90%83%E7%9A%84%E9%BE%99%E8%99%BE","CreateTime":"2018-04-28 20:19:15","CoverUrl":"","BuyNum":2,"SumPrice":40,"IsCarousel":1,"IsHot":0},{"Id":7,"SortId":0,"UserId":1,"ProductTypeId":3,"PartnerId":0,"Name":"%E5%95%86%E5%93%81%E6%B5%8B%E8%AF%953","Count":66,"Price":34,"StandardPrice":56,"Desc":"%3Cdiv%20class%3D%22dict_banner%22%20style%3D%22margin-bottom%3A%2020px%3B%20color%3A%20rgb(102%2C%20102%2C%20102)%3B%20font-family%3A%20%26quot%3BMicrosoft%20YaHei%26quot%3B%2C%20%E5%AE%8B%E4%BD%93%3B%20font-size%3A%2013px%3B%22%3E%3Ca%20id%3D%22ads_banner%22%20target%3D%22_blank%22%20href%3D%22https%3A%2F%2Fbingdict.chinacloudsites.cn%2Fdownload%3Ftag%3DBDPDV%22%20h%3D%22ID%3DDictionary%2C5090.1%22%20style%3D%22color%3A%20rgb(96%2C%200%2C%20144)%3B%22%3E%3Cimg%20width%3D%22718%22%20height%3D%2268%22%20class%3D%22rms_img%22%20src%3D%22https%3A%2F%2Fcn.bing.com%2Fth%3Fid%3DOJ.2Eh3yWRgmXNSkA%26amp%3Bpid%3DMSNJVFeeds%22%20data-bm%3D%227%22%20style%3D%22border-collapse%3A%20collapse%3B%20border-spacing%3A%200px%3B%20list-style%3A%20none%3B%20margin%3A%200px%3B%20padding%3A%200px%3B%22%3E%3C%2Fa%3E%3C%2Fdiv%3E%3Cdiv%20class%3D%22client_homepage_leftside_area%22%20style%3D%22width%3A%20273px%3B%20float%3A%20left%3B%20overflow%3A%20hidden%3B%20margin-right%3A%2015px%3B%20color%3A%20rgb(102%2C%20102%2C%20102)%3B%20font-family%3A%20%26quot%3BMicrosoft%20YaHei%26quot%3B%2C%20%E5%AE%8B%E4%BD%93%3B%20font-size%3A%2013px%3B%22%3E%3Cdiv%20class%3D%22client_daily_words_panel%22%3E%3Cdiv%20class%3D%22client_daily_word_title%20hp_title%22%20style%3D%22font-size%3A%2016px%3B%20font-weight%3A%20bold%3B%20margin-bottom%3A%2015px%3B%20width%3A%20273px%3B%20overflow%3A%20hidden%3B%20height%3A%2020px%3B%22%3E%E6%AF%8F%E6%97%A5%E8%AF%8D%E6%B1%87%3C%2Fdiv%3E%3Cdiv%20class%3D%22client_daily_word_content%22%20style%3D%22background-color%3A%20rgb(240%2C%20240%2C%20240)%3B%20padding%3A%2015px%3B%20height%3A%20270px%3B%22%3E%3Cdiv%20class%3D%22client_daily_words_bar%22%20style%3D%22overflow%3A%20hidden%3B%22%3E%3Cdiv%20class%3D%22client_daily_word_en%22%20style%3D%22overflow%3A%20hidden%3B%20padding-bottom%3A%2010px%3B%20font-size%3A%2026px%3B%22%3E%3Ca%20href%3D%22https%3A%2F%2Fcn.bing.com%2Fdict%2Fsearch%3Fq%3Dmigrate%26amp%3BFORM%3DBDVSP6%26amp%3Bmkt%3Dzh-cn%22%20h%3D%22ID%3DDictionary%2C5092.1%22%20style%3D%22color%3A%20rgb(96%2C%200%2C%20144)%3B%22%3Emigrate%3C%2Fa%3E%3C%2Fdiv%3E%3Cdiv%20class%3D%22client_daily_word_pn%22%20style%3D%22overflow%3A%20hidden%3B%20width%3A%20243px%3B%22%3E%3Cdiv%20class%3D%22client_daily_word_pn_pn%22%20lang%3D%22en%22%20style%3D%22float%3A%20left%3B%20font-size%3A%2014px%3B%20margin%3A%200px%200px%205px%3B%20line-height%3A%2020px%3B%22%3E%E7%BE%8E%5B'ma%C9%AA.%C9%A1re%C9%AAt%5D%3C%2Fdiv%3E%3Cdiv%20class%3D%22client_daily_word_pn_audio%22%20style%3D%22float%3A%20left%3B%20padding-left%3A%2010px%3B%22%3E%3Cdiv%20class%3D%22client_icon_container%22%20style%3D%22width%3A%2024px%3B%20height%3A%2024px%3B%20overflow%3A%20hidden%3B%20cursor%3A%20pointer%3B%22%3E%3Ca%20class%3D%22client_aud_o%22%20title%3D%22%E7%82%B9%E5%87%BB%E6%9C%97%E8%AF%BB%22%20h%3D%22ID%3DDictionary%2C5093.1%22%20style%3D%22color%3A%20rgb(96%2C%200%2C%20144)%3B%20display%3A%20block%3B%20width%3A%2024px%3B%20height%3A%2024px%3B%20background-image%3A%20url(%26quot%3B%2Fs%2Fdictionary%2Fspeaker_normal.png%26quot%3B)%3B%20background-repeat%3A%20no-repeat%3B%22%3E%3C%2Fa%3E%3C%2Fdiv%3E%3C%2Fdiv%3E%3C%2Fdiv%3E%3Cdiv%20class%3D%22client_daily_word_pn%22%20style%3D%22overflow%3A%20hidden%3B%20width%3A%20243px%3B%22%3E%3Cdiv%20class%3D%22client_daily_word_pn_pn%22%20lang%3D%22en%22%20style%3D%22float%3A%20left%3B%20font-size%3A%2014px%3B%20margin%3A%200px%200px%205px%3B%20line-height%3A%2020px%3B%22%3E%E8%8B%B1%5Bma%C9%AA'%C9%A1re%C9%AAt%5D%3C%2Fdiv%3E%3Cdiv%20class%3D%22client_daily_word_pn_audio%22%20style%3D%22float%3A%20left%3B%20padding-left%3A%2010px%3B%22%3E%3Cdiv%20class%3D%22client_icon_container%22%20style%3D%22width%3A%2024px%3B%20height%3A%2024px%3B%20overflow%3A%20hidden%3B%20cursor%3A%20pointer%3B%22%3E%3Ca%20class%3D%22client_aud_o%22%20title%3D%22%E7%82%B9%E5%87%BB%E6%9C%97%E8%AF%BB%22%20h%3D%22ID%3DDictionary%2C5094.1%22%20style%3D%22color%3A%20rgb(96%2C%200%2C%20144)%3B%20display%3A%20block%3B%20width%3A%2024px%3B%20height%3A%2024px%3B%20background-image%3A%20url(%26quot%3B%2Fs%2Fdictionary%2Fspeaker_normal.png%26quot%3B)%3B%20background-repeat%3A%20no-repeat%3B%22%3E%3C%2Fa%3E%3C%2Fdiv%3E%3C%2Fdiv%3E%3C%2Fdiv%3E%3Cdiv%20class%3D%22client_daily_word_zh%22%20style%3D%22overflow%3A%20hidden%3B%20padding-top%3A%205px%3B%20padding-bottom%3A%2015px%3B%20font-size%3A%2020px%3B%22%3Ev.%20%E8%BF%81%E7%A7%BB%EF%BC%9B%E7%A7%BB%E5%B1%85%3C%2Fdiv%3E%3C%2Fdiv%3E%3Cdiv%20class%3D%22client_daily_pic_bar%22%20style%3D%22overflow%3A%20hidden%3B%20width%3A%20243px%3B%22%3E%3Ca%20target%3D%22_blank%22%20class%3D%22client_daily_pic_item%22%20href%3D%22https%3A%2F%2Fcn.bing.com%2Fimages%2Fsearch%3Fq%3Dmigrate%26amp%3BFORM%3DBDCN14%26amp%3Bmkt%3Dzh-cn%22%20h%3D%22ID%3DDictionary%2C5095.1%22%20style%3D%22color%3A%20rgb(96%2C%200%2C%20144)%3B%20float%3A%20left%3B%20width%3A%2080px%3B%20height%3A%2080px%3B%20margin-right%3A%201px%3B%22%3E%3Cimg%20height%3D%2280%22%20width%3D%2280%22%20id%3D%22emb46A7C326%22%20class%3D%22rms_img%22%20src%3D%22https%3A%2F%2Fwordchallenge.blob.core.windows.net%2Fdicthpimage%2Fmigrate_1.jpg%22%20data-bm%3D%228%22%20style%3D%22border-collapse%3A%20collapse%3B%20border-spacing%3A%200px%3B%20list-style%3A%20none%3B%20margin%3A%200px%3B%20padding%3A%200px%3B%22%3E%3C%2Fa%3E%3Ca%20target%3D%22_blank%22%20class%3D%22client_daily_pic_item%22%20href%3D%22https%3A%2F%2Fcn.bing.com%2Fimages%2Fsearch%3Fq%3Dmigrate%26amp%3BFORM%3DBDCN14%26amp%3Bmkt%3Dzh-cn%22%20h%3D%22ID%3DDictionary%2C5095.2%22%20style%3D%22color%3A%20rgb(96%2C%200%2C%20144)%3B%20float%3A%20left%3B%20width%3A%2080px%3B%20height%3A%2080px%3B%20margin-right%3A%201px%3B%22%3E%3Cimg%20height%3D%2280%22%20width%3D%2280%22%20id%3D%22emb15FFA1156%22%20class%3D%22rms_img%22%20src%3D%22https%3A%2F%2Fwordchallenge.blob.core.windows.net%2Fdicthpimage%2Fmigrate_2.jpg%22%20data-bm%3D%229%22%20style%3D%22border-collapse%3A%20collapse%3B%20border-spacing%3A%200px%3B%20list-style%3A%20none%3B%20margin%3A%200px%3B%20padding%3A%200px%3B%22%3E%3C%2Fa%3E%3Ca%20target%3D%22_blank%22%20class%3D%22client_daily_pic_item%22%20href%3D%22https%3A%2F%2Fcn.bing.com%2Fimages%2Fsearch%3Fq%3Dmigrate%26amp%3BFORM%3DBDCN14%26amp%3Bmkt%3Dzh-cn%22%20h%3D%22ID%3DDictionary%2C5095.3%22%20style%3D%22color%3A%20rgb(96%2C%200%2C%20144)%3B%20float%3A%20left%3B%20width%3A%2080px%3B%20height%3A%2080px%3B%20margin-right%3A%201px%3B%22%3E%3Cimg%20height%3D%2280%22%20width%3D%2280%22%20id%3D%22emb26360BEA9%22%20class%3D%22rms_img%22%20src%3D%22https%3A%2F%2Fwordchallenge.blob.core.windows.net%2Fdicthpimage%2Fmigrate_3.jpg%22%20data-bm%3D%2210%22%20style%3D%22border-collapse%3A%20collapse%3B%20border-spacing%3A%200px%3B%20list-style%3A%20none%3B%20margin%3A%200px%3B%20padding%3A%200px%3B%22%3E%3C%2Fa%3E%3C%2Fdiv%3E%3Cdiv%20id%3D%22shareview%22%20class%3D%22client_share_bar%22%20style%3D%22margin-top%3A%2015px%3B%20padding-top%3A%205px%3B%20height%3A%2020px%3B%22%3E%3Cdiv%20class%3D%22shareText%22%20style%3D%22float%3A%20left%3B%20margin%3A%200px%2010px%200px%200px%3B%22%3E%E5%85%B1%E4%BA%AB%E5%88%B0%3A%3C%2Fdiv%3E%3C%2Fdiv%3E%3C%2Fdiv%3E%3C%2Fdiv%3E%3C%2Fdiv%3E%0A%20%20%20%20%20%20%20%20","Msg":"%E5%8D%9A%E6%A0%BC%E5%8D%8E%E7%BA%B3%E5%A5%BD%E4%B9%85%E6%B2%A1","CreateTime":"2018-05-03 10:46:28","CoverUrl":"","BuyNum":3,"SumPrice":102,"IsCarousel":0,"IsHot":0}]
		 * TmpOrder : {"Id":0,"OrderNum":"U13T1526880784136","SortId":0,"UserId":13,"AddressId":0,"Address":"%E5%9B%9B%E5%B7%9D%E7%9C%81%E6%88%90%E9%83%BD%E5%B8%82%E6%AD%A6%E4%BE%AF%E5%8C%BA%E6%AD%A6%E4%BE%AF%E7%A5%A0%E5%A4%A7%E8%A1%97264%E5%8F%B7","Receiver":"","Phone":"","Position":"{\"latitude\":30.64242,\"longitude\":104.04311}","TranslateStatus":"","PayType":"","RealPrice":0,"ShouldPrice":142,"PriceMsg":"","PartnerId":0,"CreateTime":"2018-05-21 13:33:04","OrderStatus":0,"IsPay":false,"IsDlivery":false,"IsSign":false,"IsCash":false,"IsComment":false,"IsCancel":false,"Remark":"%E5%B9%85%E5%BA%A6%E8%90%A8%E8%8A%AC%E7%9A%84","Comments":"","CancelComments":""}
		 */
		
		private TmpOrderBean TmpOrder;
		private List<ProductBean.ProductsBean> ModProducts;
		
		public TmpOrderBean getTmpOrder() {
			return TmpOrder;
		}
		
		public void setTmpOrder(TmpOrderBean TmpOrder) {
			this.TmpOrder = TmpOrder;
		}
		
		public List<ProductBean.ProductsBean> getModProducts() {
			return ModProducts;
		}
		
		public void setModProducts(List<ProductBean.ProductsBean> ModProducts) {
			this.ModProducts = ModProducts;
		}
		
		public static class TmpOrderBean {
			/**
			 * Id : 0
			 * OrderNum : U13T1526880784136
			 * SortId : 0
			 * UserId : 13
			 * AddressId : 0
			 * Address : %E5%9B%9B%E5%B7%9D%E7%9C%81%E6%88%90%E9%83%BD%E5%B8%82%E6%AD%A6%E4%BE%AF%E5%8C%BA%E6%AD%A6%E4%BE%AF%E7%A5%A0%E5%A4%A7%E8%A1%97264%E5%8F%B7
			 * Receiver :
			 * Phone :
			 * Position : {"latitude":30.64242,"longitude":104.04311}
			 * TranslateStatus :
			 * PayType :
			 * RealPrice : 0
			 * ShouldPrice : 142
			 * PriceMsg :
			 * PartnerId : 0
			 * CreateTime : 2018-05-21 13:33:04
			 * OrderStatus : 0
			 * IsPay : false
			 * IsDlivery : false
			 * IsSign : false
			 * IsCash : false
			 * IsComment : false
			 * IsCancel : false
			 * Remark : %E5%B9%85%E5%BA%A6%E8%90%A8%E8%8A%AC%E7%9A%84
			 * Comments :
			 * CancelComments :
			 */
			
			private int Id;
			private String OrderNum;
			private int SortId;
			private int UserId;
			private int AddressId;
			private String Address;
			private String Receiver;
			private String Phone;
			private String Position;
			private String TranslateStatus;
			private String PayType;
			private int RealPrice;
			private int ShouldPrice;
			private String PriceMsg;
			private int PartnerId;
			private String CreateTime;
			private int OrderStatus;
			private boolean IsPay;
			private boolean IsDlivery;
			private boolean IsSign;
			private boolean IsCash;
			private boolean IsComment;
			private boolean IsCancel;
			private String Remark;
			private String Comments;
			private String CancelComments;
			
			public int getId() {
				return Id;
			}
			
			public void setId(int Id) {
				this.Id = Id;
			}
			
			public String getOrderNum() {
				return OrderNum;
			}
			
			public void setOrderNum(String OrderNum) {
				this.OrderNum = OrderNum;
			}
			
			public int getSortId() {
				return SortId;
			}
			
			public void setSortId(int SortId) {
				this.SortId = SortId;
			}
			
			public int getUserId() {
				return UserId;
			}
			
			public void setUserId(int UserId) {
				this.UserId = UserId;
			}
			
			public int getAddressId() {
				return AddressId;
			}
			
			public void setAddressId(int AddressId) {
				this.AddressId = AddressId;
			}
			
			public String getAddress() {
				return Address;
			}
			
			public void setAddress(String Address) {
				this.Address = Address;
			}
			
			public String getReceiver() {
				return Receiver;
			}
			
			public void setReceiver(String Receiver) {
				this.Receiver = Receiver;
			}
			
			public String getPhone() {
				return Phone;
			}
			
			public void setPhone(String Phone) {
				this.Phone = Phone;
			}
			
			public String getPosition() {
				return Position;
			}
			
			public void setPosition(String Position) {
				this.Position = Position;
			}
			
			public String getTranslateStatus() {
				return TranslateStatus;
			}
			
			public void setTranslateStatus(String TranslateStatus) {
				this.TranslateStatus = TranslateStatus;
			}
			
			public String getPayType() {
				return PayType;
			}
			
			public void setPayType(String PayType) {
				this.PayType = PayType;
			}
			
			public int getRealPrice() {
				return RealPrice;
			}
			
			public void setRealPrice(int RealPrice) {
				this.RealPrice = RealPrice;
			}
			
			public int getShouldPrice() {
				return ShouldPrice;
			}
			
			public void setShouldPrice(int ShouldPrice) {
				this.ShouldPrice = ShouldPrice;
			}
			
			public String getPriceMsg() {
				return PriceMsg;
			}
			
			public void setPriceMsg(String PriceMsg) {
				this.PriceMsg = PriceMsg;
			}
			
			public int getPartnerId() {
				return PartnerId;
			}
			
			public void setPartnerId(int PartnerId) {
				this.PartnerId = PartnerId;
			}
			
			public String getCreateTime() {
				return CreateTime;
			}
			
			public void setCreateTime(String CreateTime) {
				this.CreateTime = CreateTime;
			}
			
			public int getOrderStatus() {
				return OrderStatus;
			}
			
			public void setOrderStatus(int OrderStatus) {
				this.OrderStatus = OrderStatus;
			}
			
			public boolean isIsPay() {
				return IsPay;
			}
			
			public void setIsPay(boolean IsPay) {
				this.IsPay = IsPay;
			}
			
			public boolean isIsDlivery() {
				return IsDlivery;
			}
			
			public void setIsDlivery(boolean IsDlivery) {
				this.IsDlivery = IsDlivery;
			}
			
			public boolean isIsSign() {
				return IsSign;
			}
			
			public void setIsSign(boolean IsSign) {
				this.IsSign = IsSign;
			}
			
			public boolean isIsCash() {
				return IsCash;
			}
			
			public void setIsCash(boolean IsCash) {
				this.IsCash = IsCash;
			}
			
			public boolean isIsComment() {
				return IsComment;
			}
			
			public void setIsComment(boolean IsComment) {
				this.IsComment = IsComment;
			}
			
			public boolean isIsCancel() {
				return IsCancel;
			}
			
			public void setIsCancel(boolean IsCancel) {
				this.IsCancel = IsCancel;
			}
			
			public String getRemark() {
				return Remark;
			}
			
			public void setRemark(String Remark) {
				this.Remark = Remark;
			}
			
			public String getComments() {
				return Comments;
			}
			
			public void setComments(String Comments) {
				this.Comments = Comments;
			}
			
			public String getCancelComments() {
				return CancelComments;
			}
			
			public void setCancelComments(String CancelComments) {
				this.CancelComments = CancelComments;
			}
		}
		
	}
}
