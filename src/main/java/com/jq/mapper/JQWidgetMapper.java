package com.jq.mapper;
import com.jq.entity.JQWidget;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;


@Mapper
public interface JQWidgetMapper {

	/**
	 * Get All widget Information
	 * @return
	 */
	List<JQWidget> getWidgets();

	/**
	 * Get  widget Information by Name
	 * @return
	 */

	JQWidget getWidgetByName(String name);


	void assignProperty(int widgetId, int propertyId);

}
