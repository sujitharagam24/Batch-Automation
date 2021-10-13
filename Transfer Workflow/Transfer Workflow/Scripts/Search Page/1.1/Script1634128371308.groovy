def docType = 'Bill of Sale'

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/Search Doc Type'), docType);

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/Search Button'));

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/Search Criteria'));

def recDocNumber = '20190254835'

WebUI.setText(findTestObject('Object Repository/Search Page Objectory/US8325/Page_Transfer Workflow/Record Doc number From field'),
	recDocNumber);

def to = '20190254850'

WebUI.setText(findTestObject('Object Repository/Search Page Objectory/US8325/Record Doc Number To Field'),
	to);

def docType = 'Affidavit of Deth'

WebUI.click(findTestObject('Object Repository/Search Page Objectory/US8325/Search Doc Type'), docType);


