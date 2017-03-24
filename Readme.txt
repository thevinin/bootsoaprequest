1. Set the URL for the WSDL
    In the pom,
		<schemas>
			<schema>
				<url></url> <!- Set URL to URL for WSDL or ->
				<file></file> <!-- set file location for WSDL ->
			</schema>
		</schemas>
    -- for Project Server API - wsdl location:
    \a1d41009app.online15.net\ProjectServer\_vti_bin\PSI\Resource.asmx?wsdl
2.  Set the package for the generated classes
    In the POM,
		<generatePackage><package name for generated classes></generatePackage>

3. Execute Maven goal generate sources to create Java classes from WSDL
    mvn jaxb2:generate
