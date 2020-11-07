package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository repository;

	@Override
	public Quote getQuote() {
		int leftLimit = 0;
		int rightLimit = 18306;
		int id = leftLimit + (int) (Math.random() * (rightLimit - leftLimit));
		return repository.findById(id).orElse(null);
	}

	@Override
	public Quote getQuoteByActor(String actor) {
		List<Quote> quotes = repository.findByActor(actor);
		return quotes.get(new Random().nextInt(quotes.size()));
	}

}
