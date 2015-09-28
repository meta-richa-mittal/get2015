package xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import pojoClasses.Bike;
import pojoClasses.Car;
import pojoClasses.Vehicle;

public class XmlParsing {

	static final String VEHICLEDETAIL = "vehicleDetail";
	static final String TYPE = "type";
	static final String CREATEDBY = "created_by";
	static final String CREATEDTIME = "created_time";
	static final String ID = "id";
	static final String MAKE = "make";
	static final String MODEL = "model";
	static final String ENGINEINCC = "engineInCC";
	static final String FUELCAPACITY = "fuelCapacity";
	static final String MILEAGE = "milage";
	static final String PRICE = "price";
	static final String ROADTAX = "roadtax";
	static final String AC = "ac";
	static final String POWERSTEERING = "powerSteering";
	static final String ACCESSORYKIT = "accessoryKit";
	static final String SELFSTART = "selfStart";
	static final String HELMETPRICE = "helmetPrice";

	
	public List<Vehicle> readConfig(String vehicleFile) {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		try {
			// First, create a new XMLInputFactory
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			// Setup a new eventReader
			InputStream in = new FileInputStream(vehicleFile);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			// read the XML document
			Vehicle vehicle  = null;

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				
				// System.out.println("event:"+event);
				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					
					// If we have an item element, we create a new vehicle according their type
					if (startElement.getName().getLocalPart() == (VEHICLEDETAIL)) {
						
						// We read the attributes from this tag and check the type						
						@SuppressWarnings("unchecked")
						Iterator<Attribute> attributes = startElement.getAttributes();
						  while (attributes.hasNext()) {
							  Attribute attribute = attributes.next();
							  if (attribute.getName().toString().equals(TYPE)) {
								  if(attribute.getValue().equalsIgnoreCase("car")){
									  vehicle = new Car();	
								  }
								  else {
									  vehicle = new Bike();
								  }
							  }
						  }
						 
					}
						/*if (event.asStartElement().getName().getLocalPart()
								.equals(ID)) {

							event = eventReader.nextEvent();
							newVehicle.setId((event
									.asCharacters().getData()).toString());
						}
						else if (event.asStartElement().getName().getLocalPart()
								.equals(CREATEDBY)) {
							event = eventReader.nextEvent();
							newVehicle.setCreated_by((event
									.asCharacters().getData()).toString());
							
						}
						else if (event.asStartElement().getName().getLocalPart()
								.equals(CREATEDTIME)) {
							event = eventReader.nextEvent();
							newVehicle.setCreated_time(event.asCharacters().getData().toString());
							
						}
						else if (event.asStartElement().getName().getLocalPart()
								.equals(MAKE)) {
							event = eventReader.nextEvent();
							newVehicle.setMake(event.asCharacters().getData());
							
						}
						else if (event.asStartElement().getName().getLocalPart()
								.equals(MODEL)) {
							event = eventReader.nextEvent();
							newVehicle.setModel(event.asCharacters().getData());
							
						}
						else if (event.asStartElement().getName().getLocalPart()
								.equals(ENGINEINCC)) {
							event = eventReader.nextEvent();
							newVehicle.setEngineInCC(Integer.parseInt(event
									.asCharacters().getData()));
							
						}
						else if (event.asStartElement().getName().getLocalPart()
								.equals(FUELCAPACITY)) {
							event = eventReader.nextEvent();
							newVehicle.setFuelCapacity(Integer.parseInt(event
									.asCharacters().getData()));
							
						}
						else if (event.asStartElement().getName().getLocalPart()
							.equals(MILEAGE)) {
						event = eventReader.nextEvent();
						newVehicle.setMilage(Integer.parseInt(event.asCharacters()
								.getData()));
						}
						else if (event.asStartElement().getName().getLocalPart()
								.equals(PRICE)) {
							event = eventReader.nextEvent();
							newVehicle.setPrice(Integer.parseInt(event.asCharacters()
									.getData()));
							
						}
						else if (event.asStartElement().getName().getLocalPart()
								.equals(ROADTAX)) {
							event = eventReader.nextEvent();
							newVehicle.setRoadTax(Integer.parseInt(event
									.asCharacters().getData()));
						
						}
						else if (event.asStartElement().getName().getLocalPart()
								.equals(AC)) {
							event = eventReader.nextEvent();
							((Car) newVehicle).setAC(Boolean.parseBoolean(event.asCharacters()
									.getData()));
							
						}
						else if (event.asStartElement().getName().getLocalPart()
								.equals(POWERSTEERING)) {
							event = eventReader.nextEvent();
							((Car) newVehicle).setPowerSteering(Boolean.parseBoolean(event
									.asCharacters().getData()));
							
						}
						else if (event.asStartElement().getName().getLocalPart()
								.equals(ACCESSORYKIT)) {
							event = eventReader.nextEvent();
							((Car) newVehicle).setAccessoryKit(event.asCharacters().getData());
							
						}
						else if (event.asStartElement().getName().getLocalPart()
								.equals(SELFSTART)) {
							event = eventReader.nextEvent();
							((Bike) newVehicle).setSelfStart(Boolean.parseBoolean(event.asCharacters().getData()));
						}
						else if (event.asStartElement().getName().getLocalPart()
								.equals(HELMETPRICE)) {
							event = eventReader.nextEvent();
							((Bike) newVehicle).setHelmetPrice(Integer.parseInt(event.asCharacters().getData()));	
							
						}*/
					// If we reach the end of an item element, we add it to the
					
					String key=event.asStartElement().getName().getLocalPart();
					event = eventReader.nextEvent();
					
					switch (key) {
						case ID:
							vehicle.setId((event
									.asCharacters().getData()).toString());
							break;
						case CREATEDBY:
							vehicle.setCreated_by((event
									.asCharacters().getData()).toString());
							break;
						case CREATEDTIME:
							vehicle.setCreated_time(event.asCharacters().getData().toString());
							break;
						case MAKE:
							vehicle.setMake((event
									.asCharacters().getData()).toString());
							break;
						case MODEL:
							vehicle.setModel((event
									.asCharacters().getData()).toString());
							break;
						case ENGINEINCC:
							vehicle.setEngineInCC((Integer.parseInt(event
									.asCharacters().getData())));
							break;
						case FUELCAPACITY:
							vehicle.setFuelCapacity((Integer.parseInt(event
									.asCharacters().getData())));
							break;
						case MILEAGE:
							vehicle.setMilage((Integer.parseInt(event
									.asCharacters().getData())));
							break;
						case PRICE:
							vehicle.setPrice((Integer.parseInt(event
									.asCharacters().getData())));
							break;
						case ROADTAX:
							vehicle.setRoadTax((Integer.parseInt(event
									.asCharacters().getData())));
							break;
						case AC:
							((Car) vehicle).setAC(Boolean.parseBoolean(event.asCharacters()
									.getData()));
							break;
						case POWERSTEERING:
							((Car) vehicle).setPowerSteering(Boolean.parseBoolean(event
									.asCharacters().getData()));
							break;
						case ACCESSORYKIT:
							((Car) vehicle).setAccessoryKit(event.asCharacters().getData());
							break;
						case SELFSTART:
							((Bike) vehicle).setSelfStart(Boolean.parseBoolean(event.asCharacters().getData()));
							break;
						case HELMETPRICE:
							((Bike) vehicle).setHelmetPrice(Integer.parseInt(event.asCharacters().getData()));	
							break;
							
					}

				}
				
				if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart() == (VEHICLEDETAIL)) {
							vehicles.add(vehicle);	
					}
				}
			}	
		} 
		catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		} 
		catch (XMLStreamException e) {
			System.out.println("Error in XML processing");
			e.printStackTrace();
		}
		catch(ClassCastException cce) {
			System.out.println("Error in casting class");
			cce.printStackTrace();
		}
		return vehicles;
	}
}