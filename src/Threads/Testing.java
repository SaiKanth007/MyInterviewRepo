import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import javax.ws.rs.core.UriBuilder;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * //*********************************************** // Copyright UNITEDHEALTH GROUP CORPORATION 2018. // This software
 * and documentation contain confidential and // proprietary information owned by UnitedHealth Group Corporation. //
 * Unauthorized use and distribution are prohibited. //***********************************************
 */

/**
 */
public class Testing {

    final static String initialPath =
                    "/*[local-name()='Envelope']/*[local-name()='Body']/CurrentIncomeRequestPayloadType/*[local-name()='ResponseInformation']/*[local-name()='CurrentIncomeInformation']";

    final static String paymentEndDate =
                    "/*[local-name()='PayPeriod']/*[local-name()='PayPeriodInformation']/*[local-name()='PayPeriodEndDate']/*[local-name()='payPeriodEndDate']/text()";

    final static String incomes =
                    "/*[local-name()='PayPeriod']/*[local-name()='PayPeriodInformation']/*[local-name()='IncomeDetail']/*[local-name()='IncomeAmount']/text()";

    final static String incomeDates =
                    "/*[local-name()='PayPeriod']/*[local-name()='PayPeriodInformation']/*[local-name()='IncomeDetail']/*[local-name()='IncomeDate']/*[local-name()='payPeriodEndDate']/text()";

    final static String baseCompensation =
                    "/*[local-name()='BaseCompensationInformation']/*[local-name()='PayPeriodFrequencyMessage']/text()";

    final static String annualIncome =
                    "/*[local-name()='BaseCompensationInformation']/*[local-name()='AnnualizedIncome']/text()";

    final static String incomePath = initialPath + incomes;

    final static String paymentEndDatePaths = initialPath + paymentEndDate;

    final static String incomeDatesPath = initialPath + incomeDates;

    final static String baseCompensationPath = initialPath + baseCompensation;

    final static String annualIncomePath = initialPath + annualIncome;

    final static String[] xpaths =
                    {incomePath, paymentEndDatePaths, incomeDatesPath, baseCompensationPath, annualIncomePath};

    final static String response =

                    "<env:Envelope xmlns:env=\"http://www.w3.org/2003/05/soap-envelope\"><env:Header/><env:Body><CurrentIncomeRequestPayloadType xmlns:ns2=\"http://niem.gov/niem/structures/2.0\" xmlns:ns3=\"http://hix.cms.gov/0.1/hix-core\" xmlns:ns4=\"http://vci.dsh.cms.gov/extension/1.0\" xmlns:ns5=\"http://niem.gov/niem/niem-core/2.0\" xmlns:ns6=\"http://niem.gov/niem/appinfo/2.0\" xmlns:ns7=\"http://niem.gov/niem/appinfo/2.1\" xmlns:ns8=\"http://vci.dsh.cms.gov/exchange/1.0\" ns2:id=\"Response\"><ns4:ResponseMetadata ns2:id=\"1\"><ns3:ResponseCode ns2:id=\"Response Code\">HS000000</ns3:ResponseCode><ns3:ResponseDescriptionText ns2:id=\"Response Description\">Success</ns3:ResponseDescriptionText></ns4:ResponseMetadata><ns4:ResponseInformation ns2:id=\"Current Income Info Type\"><ns4:EmployeeInformation ns2:id=\"Person Type\"><ns5:PersonName ns2:id=\"Person Name Type\"><ns5:PersonGivenName ns2:id=\"Person Name Text Type\">first name</ns5:PersonGivenName></ns5:PersonName></ns4:EmployeeInformation><ns4:CurrentIncomeInformation><ns4:Tier>0</ns4:Tier><ns4:EmployeeInformation ns2:id=\"Emp345\"><ns5:PersonName ns2:id=\"Emp3456\"><ns5:PersonGivenName ns2:id=\"PNTT1\">Joey</ns5:PersonGivenName></ns5:PersonName></ns4:EmployeeInformation><ns4:EmployerInformation><ns4:EmployerOrganization ns2:id=\"org1234\"><ns5:OrganizationIdentification ns2:id=\"ORGIDT1234\"><ns5:IdentificationID ns2:id=\"ORGIDT1234\">ORGIDT1234</ns5:IdentificationID></ns5:OrganizationIdentification><ns5:OrganizationName ns2:id=\"OraganizationOne\">OraganizationOne</ns5:OrganizationName></ns4:EmployerOrganization><ns4:EmployerAddress/></ns4:EmployerInformation><ns4:EmploymentInformation/><ns4:BaseCompensationInformation><ns4:PayRate ns2:id=\"payRate\"><ns3:IncomeAmount ns2:id=\"Pay1\">80</ns3:IncomeAmount><ns3:IncomeDate xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"ns4:DateOnlyDateType\"><ns11:payPeriodEndDate xmlns:ns11=\"PayPeriodInformationType\">2018-01-1</ns11:payPeriodEndDate></ns3:IncomeDate></ns4:PayRate><ns4:PayPeriodFrequencyCode ns2:id=\"payFrequencyCode\">6</ns4:PayPeriodFrequencyCode><ns4:PayPeriodFrequencyMessage ns2:id=\"payFrequencydType\">Bi-Weekly</ns4:PayPeriodFrequencyMessage><ns4:AnnualizedIncome ns2:id=\"annualIncome\">1192</ns4:AnnualizedIncome></ns4:BaseCompensationInformation><ns4:AnnualCompensation ns2:id=\"AnnualComp1234\"/><ns4:PayPeriod><ns4:PayPeriodInformation><ns4:PayPeriodEndDate><ns10:payPeriodEndDate xmlns:ns10=\"PayPeriodInformationType\">2018-01-07</ns10:payPeriodEndDate></ns4:PayPeriodEndDate><ns4:IncomeDetail><ns3:IncomeAmount ns2:id=\"Pay1\">80</ns3:IncomeAmount><ns3:IncomeDate xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"ns4:DateOnlyDateType\"><ns11:payPeriodEndDate xmlns:ns11=\"PayPeriodInformationType\">2018-01-1</ns11:payPeriodEndDate></ns3:IncomeDate></ns4:IncomeDetail></ns4:PayPeriodInformation><ns4:PayPeriodInformation><ns4:PayPeriodEndDate><ns10:payPeriodEndDate xmlns:ns10=\"PayPeriodInformationType\">2017-12-24</ns10:payPeriodEndDate></ns4:PayPeriodEndDate><ns4:IncomeDetail><ns3:IncomeAmount ns2:id=\"Pay2\">190</ns3:IncomeAmount><ns3:IncomeDate xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"ns4:DateOnlyDateType\"><ns11:payPeriodEndDate xmlns:ns11=\"PayPeriodInformationType\">2017-12-29</ns11:payPeriodEndDate></ns3:IncomeDate></ns4:IncomeDetail></ns4:PayPeriodInformation><ns4:PayPeriodInformation><ns4:PayPeriodEndDate><ns10:payPeriodEndDate xmlns:ns10=\"PayPeriodInformationType\">2017-11-2</ns10:payPeriodEndDate></ns4:PayPeriodEndDate><ns4:IncomeDetail><ns3:IncomeAmount ns2:id=\"Pay3\">64.8299999999999982946974341757595539093017578125</ns3:IncomeAmount><ns3:IncomeDate xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"ns4:DateOnlyDateType\"><ns11:payPeriodEndDate xmlns:ns11=\"PayPeriodInformationType\">2017-12-01</ns11:payPeriodEndDate></ns3:IncomeDate></ns4:IncomeDetail></ns4:PayPeriodInformation></ns4:PayPeriod></ns4:CurrentIncomeInformation></ns4:ResponseInformation></CurrentIncomeRequestPayloadType></env:Body></env:Envelope>";

    public static void main(String[] args)
                    throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {

        System.out.println("12u3".matches("\\d+"));

        Date.valueOf("2018-01-01");

        // System.out.println(new BigDecimal(""));

        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss", Locale.US);

        final String strLocalDate = "2015-10-23T03:34:40";

        final LocalDateTime localDate = LocalDateTime.parse(strLocalDate, formatter);

        System.out.println(localDate);
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDate));
        // System.out.println(LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault()));
        // System.out.println(date.getTime());
        // String uuid = "41690ccf-5433-4393-bd66-64f1ab7dd79b";
        // System.out.println("NEI-'LSONm".replaceAll("[^a-zA-Z]", ""));

        // try {
        // if (StringUtils.isNotBlank(uuid)) {
        // uuid = uuid.split(" ")[0];
        // System.out.println(uuid);
        // return;
        //
        // }
        // }
        //
        // finally {
        // //System.out.println("Sai");
        // }

        final UriBuilder builder = UriBuilder
            .fromPath("https://ie-api-gw-dev.optum.com/api/ie/eligibility/v2/{tenantId}/caseEligibilityService/{userId}/{caseId}/{eventId}");
        builder.queryParam("casePrograms", "{benefitProgram}");

        System.out.println(builder.build("1", "SAI", "1234", "9876", "Healthcare").toString());

    }

    public static Map<String, NodeList> parseVerificatioResponse(String stringResponse, String... xpaths)
                    throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {

        final Map<String, NodeList> returnValues = new HashMap<>();

        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        factory.setNamespaceAware(true);

        final DocumentBuilder builder = factory.newDocumentBuilder();
        final InputStream stream = new ByteArrayInputStream(stringResponse.getBytes(StandardCharsets.UTF_8));
        final Document doc = builder.parse(stream);

        final XPathFactory xpathFactory = XPathFactory.newInstance();
        final XPath xpath = xpathFactory.newXPath();
        final List<String> payPeriodendDates = new ArrayList<>();

        final List<String> payChecks = new ArrayList<>();
        final List<String> payDates = new ArrayList<>();
        Double amount = null;
        String frequency = null;
        Boolean fluctuatingIncomeAmount = true;

        for (Integer index = 0; index < xpaths.length; index++) {

            final XPathExpression ssnExpr = xpath.compile(xpaths[index]);
            final NodeList nodeList = (NodeList) ssnExpr.evaluate(doc, XPathConstants.NODESET);

            for (int i = 0; i < nodeList.getLength(); i++) {

                if (xpaths[index].equals(incomePath)) {
                    payChecks.add(nodeList.item(i).getNodeValue());
                }
                if (xpaths[index].equals(paymentEndDatePaths)) {
                    payPeriodendDates.add(nodeList.item(i).getNodeValue());
                }
                if (xpaths[index].equals(annualIncomePath) && Objects.nonNull(nodeList.item(i).getNodeValue())) {
                    amount = Double.parseDouble(nodeList.item(i).getNodeValue());
                }
                if (xpaths[index].equals(baseCompensationPath) && Objects.nonNull(nodeList.item(i).getNodeValue())) {
                    frequency = nodeList.item(i).getNodeValue();
                }
                if (xpaths[index].equals(incomeDatesPath) && Objects.nonNull(nodeList.item(i).getNodeValue())) {
                    payDates.add(nodeList.item(i).getNodeValue());
                }

            }
            returnValues.put(xpaths[index], nodeList);

        }

        Collections.sort(payPeriodendDates, new Comparator<String>() {
            @Override
            public int compare(String object1, String object2) {
                return object1.compareTo(object2);
            }
        });

        final Map<String, String> map = new HashMap<>();
        for (int i = 0; i < payDates.size(); i++) {
            map.put(payDates.get(i), payChecks.get(i));
        }
        final List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        payDates.clear();
        payChecks.clear();
        for (int i = 0; i < map.size(); i++) {
            payDates.add(list.get(i));
            payChecks.add(map.get(list.get(i)));
        }

        Collections.sort(payChecks, Comparator.comparing(item -> payDates.indexOf(item)));
        payPeriodendDates.get(0);
        payPeriodendDates.get(payPeriodendDates.size() - 1);
        payPeriodendDates.get(0);
        payPeriodendDates.get(payPeriodendDates.size() - 1);
        if (payChecks.stream().distinct().count() == 1) {
            fluctuatingIncomeAmount = false;

        }
        System.out.println(fluctuatingIncomeAmount);
        System.out.println(frequency);
        System.out.println(amount);

        return returnValues;

    }
}
