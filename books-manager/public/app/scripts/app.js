var BooksManager = window.BooksManager = Ember.Application.create({
	 LOG_TRANSITIONS: true,
});

/* Order and include as you please. */
require('scripts/routes/*');
require('scripts/controllers/*');
require('scripts/models/*');
require('scripts/views/*');
require('scripts/adapter');
require('scripts/router');