package com.github.dandelion.datatables.core.processor;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockPageContext;
import org.springframework.mock.web.MockServletContext;

import com.github.dandelion.datatables.core.config.ColumnConfiguration;
import com.github.dandelion.datatables.core.config.DatatableOptions;
import com.github.dandelion.datatables.core.config.TableConfiguration;
import com.github.dandelion.datatables.core.config.TableConfigurationFactory;
import com.github.dandelion.datatables.core.option.Option;
import com.github.dandelion.datatables.core.option.processor.EmptyStringProcessor;
import com.github.dandelion.datatables.core.option.processor.OptionProcessingContext;
import com.github.dandelion.datatables.core.option.processor.OptionProcessor;

import static org.assertj.core.api.Assertions.assertThat;

public class EmptyStringProcessorTest {

	protected TableConfiguration tableConfiguration;
	protected ColumnConfiguration columnConfiguration;
	protected HttpServletRequest request;
	protected Map<Option<?>, Object> confToBeApplied;

	@Before
	public void setup() {
		MockServletContext mockServletContext = new MockServletContext();
		MockPageContext mockPageContext = new MockPageContext(mockServletContext);
		request = (HttpServletRequest) mockPageContext.getRequest();
		confToBeApplied = new HashMap<Option<?>, Object>();
		tableConfiguration = TableConfigurationFactory.getInstance("tableId", request, null);
		columnConfiguration = new ColumnConfiguration();
	}

	@Test
	public void should_update_the_table_entry_with_an_empty_string() throws Exception{
		Entry<Option<?>, Object> entry = new MapEntry<Option<?>, Object>(DatatableOptions.AJAX_SERVERDATA, "");
		OptionProcessor processor = new EmptyStringProcessor();
		OptionProcessingContext pc = new OptionProcessingContext(entry, tableConfiguration, columnConfiguration);
		processor.process(pc);
		assertThat(entry.getValue()).isEqualTo("");
	}
	
	@Test
	public void should_update_the_column_entry_with_an_empty_string() throws Exception{
		Entry<Option<?>, Object> entry = new MapEntry<Option<?>, Object>(DatatableOptions.AJAX_SERVERDATA, "");
		OptionProcessor processor = new EmptyStringProcessor();
		OptionProcessingContext pc = new OptionProcessingContext(entry, tableConfiguration, columnConfiguration);
		processor.process(pc);
		assertThat(entry.getValue()).isEqualTo("");
	}
}