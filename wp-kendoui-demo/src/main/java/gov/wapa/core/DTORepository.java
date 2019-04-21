
/*********************************************************************************************
 * @COPYRIGHT 					(c) 2018 WAPA, BILLINGS,MONTANA ALL RIGHTS RESERVED 
 * 				THIS SOFTWARE IS FURNISHED UNDER A LICENSE AND MAY BE USED AND COPIED ONLY IN
 *            	ACCORDANCE WITH THE TERMS OF SUCH LICENSE AND WITH THE INCLUSION OF THE ABOVE COPYRIGHT NOTICE. 
 *            	THIS SOFTWARE OR ANY OTHER COPIES THEREOF MAY NOT BE PROVIDED OR OTHERWISE MADE AVAILABLE TO ANY OTHER PERSON. 
 *            	NO TITLE TO AND OWNERSHIP OF THE SOFTWARE IS HEREBY TRANSFERRED.
 * 
 * @DESCRIPTION : Used for supporting a flat dto object objects
 * 
 * @PROGRAM : application template :  11/15/2018 FUNCTION :
 * 
 * @ENVIRONMENT : java
 * 
 * 
 * @MODIFICATION HISTORY:
 *
 * 
 * @author Emmanuel Romulus
 *
 ***********************************************************************************************/
package gov.wapa.core;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.StdDateFormat;

/**
 * Used for supporting a flat dto object objects
 * 
 * @author romulus
 *
 */
@Repository
public class DTORepository {
	public final static String STRING_TYPE = "string";
	public final static String ARRAY_TYPE = "array";
	public final static String DATETIME_TYPE = "datetime";
	public final static String BOOLEAN_Y_N_TYPE = "y_n";
	public final static String BOOLEAN_1_0_TYPE = "1_0";
	public final static String BOOLEAN_T_F_TYPE = "t_f";
	public final static String BOOLEAN_TRUE_FALSE_TYPE = "true_false";

	// get the entity manager to create queries;
	/*
	 * @Autowired private EntityManager entityManager;
	 */

	/**
	 * 
	 * @param nativeSqlString
	 * @param propertyInfos
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public <T> List<T> getDataObjects(String nativeSqlString, DTORepositoryMapper propertyInfos, Class<T> clazz)
			throws Exception {

		return getDataObjects(nativeSqlString, null, propertyInfos, clazz);
	}

	/**
	 * 
	 * @param nativeSqlString
	 * @param parameterMap
	 * @param propertyInfos
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public <T> List<T> getDataObjects(String nativeSqlString, Map<String, Object> parameterMap,
			DTORepositoryMapper propertyInfos, Class<T> clazz) throws Exception {
		List<T> list = null;
		//Query query = entityManager.createNativeQuery(nativeSqlString);

		// Set parameters
		if (parameterMap != null) {
		//	parameterMap.forEach((k, v) -> query.setParameter(k, v));
		}

		try {

			/*
			 * execute the query and store the result in the xmlClobData
			 */
			//@SuppressWarnings("unchecked")
			List<Object[]> results = null;// query.getResultList();
			String jsonData = convertSqlResultToJson(results, propertyInfos);
			if (jsonData != null && jsonData.isEmpty() == false) {

				list = convertJsonToPOJO(jsonData, clazz);
			}

		} catch (Exception e) {

			System.out.println("Error during query execution. \n" + e.getMessage());
		}

		return list;
	}

	/**
	 * 
	 * @param nativeSqlString
	 * @param propertyInfos
	 * @return
	 * @throws Exception
	 */
	public String getJsonData(String nativeSqlString, DTORepositoryMapper propertyInfos) throws Exception {

		return getJsonData(nativeSqlString, null, propertyInfos);
	}

	/**
	 * 
	 * @param nativeSqlString
	 * @param parameterMap
	 * @param propertyInfos
	 * @return
	 * @throws Exception
	 */
	public String getJsonData(String nativeSqlString, Map<String, Object> parameterMap,
			DTORepositoryMapper propertyInfos) throws Exception {
		String jsonData = null;
		//Query query = entityManager.createNativeQuery(nativeSqlString);

		// Set parameters
		if (parameterMap != null) {
			//parameterMap.forEach((k, v) -> query.setParameter(k, v));
		}

		try {

			/*
			 * execute the query and store the result in the xmlClobData
			 */
			//@SuppressWarnings("unchecked")
			List<Object[]> results = null;//query.getResultList();
			jsonData = convertSqlResultToJson(results, propertyInfos);

		} catch (Exception e) {

			System.out.println("Error during query execution. \n" + e.getMessage());
		}

		return jsonData;
	}

	/**
	 * 
	 * @param results
	 * @param queryColumnNames
	 * @return
	 * @throws Exception
	 * @throws JsonProcessingException
	 */
	private String convertSqlResultToJson(List<Object[]> results, DTORepositoryMapper propertyInfos) throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		ArrayNode jsonArray = mapper.createArrayNode();

		for (Object[] columns : results) {
			/*
			 * list of properties cannot be greater than the result
			 */
			if (propertyInfos.size() > columns.length) {
				return null;
			}

			ObjectNode node = mapper.createObjectNode();

			for (int i = 0; i < propertyInfos.size(); i++) {

				String value = columns[i] == null ? null : columns[i].toString();
				/*
				 * validate value based on type check the type to use the appropriate json here
				 * to see if date. if so, create the right format
				 */
				DTORepositoryPropertyInfo info = propertyInfos.get(i);
				String type = info.getPropertyType();
				if (type != null && type.isEmpty() == false && value != null) {
					switch (type) {
					case DTORepository.DATETIME_TYPE:
						value = value.replace(" ", "T");
						break;
					case DTORepository.BOOLEAN_Y_N_TYPE:
						value = value != null && value.toLowerCase().equals("Y") ? "true" : "false";
						break;
					case DTORepository.BOOLEAN_1_0_TYPE:
						value = value != null && value.toLowerCase().equals("1") ? "true" : "false";
						break;
					case DTORepository.BOOLEAN_T_F_TYPE:
						value = value != null && value.toLowerCase().equals("t") ? "true" : "false";
						break;
					case DTORepository.BOOLEAN_TRUE_FALSE_TYPE:
						value = value != null && value.toLowerCase().equals("true") ? "true" : "false";
						break;

					case DTORepository.ARRAY_TYPE:
						break;

					default:
						throw new Exception("Invalid or unsupported type specified!");
					}
				}

				/*
				 * add the value to the node, and move on to the next column
				 */
				if (value != null)
					node.put(info.getPropertyName(), value);
			}

			jsonArray.add(node);
		}

		/*
		 * return valid json
		 */
		String json = null;
		try {
			json = mapper.writeValueAsString(jsonArray);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * Mapped json objects to pojos using the target class
	 * 
	 * @param jsonData
	 * @author romulus
	 * @return
	 */
	public static <T> List<T> convertJsonToPOJO(String jsonData, Class<T> clazz) {
		/*
		 * Create the target list
		 */
		List<T> datalist = null;

		ObjectMapper mapper = new ObjectMapper(); // Create a mapper configure it to not fail on unknown properties
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.setDateFormat(new StdDateFormat());
		try {
			/*
			 * create a collectionliketype reference that will tell the mapper what class to
			 * use to deserialize those objects
			 */
			CollectionLikeType typeref = TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, clazz);
			JsonNode actualObj = mapper.readTree(jsonData);
			JsonParser jparser = actualObj.traverse();
			datalist = mapper.readValue(jparser, typeref);

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return datalist;
	}

}
