/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.wozi.spring.tutorial.bootsoaprequest;

import hello.wsdl.GetQuoteResponse;
import net.wozi.spring.tutorial.bootsoaprequest.client.QuoteClient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner lookup(QuoteClient quoteClient){
		return args-> {
			String ticker = "MSFT";

			if (args.length > 0) ticker = args[0];
			GetQuoteResponse response = quoteClient.getQuote(ticker);
			System.out.println(response.getGetQuoteResult());
		};
	}

}
