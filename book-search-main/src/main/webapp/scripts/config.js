define({
	app_name : "BooksApp",
	shim : {
		'ember' : {
			deps : [ 'handlebars', 'jquery' ],
			exports : 'Ember'
		},
		'ember_data' : {
			deps : [ 'ember' ],
			exports : 'DS'
		},
		'endless' : {
			deps : [ 'jquery' ],
			exports : 'endless'
		},
		'inview' : {
			deps : [ 'jquery' ],
			exports : 'inview'
		},
		 waitSeconds:15
	},
	paths : {
		'App' : 'app/main',
		'models' : 'app/models',
		'views' : 'app/views',
		'router' : 'app/views',
		'controllers' : 'app/controllers',
		'templates' : 'app/templates',
		/* libs */
		'jquery' : 'libs/jquery/1.8.3/jquery',
		'inview' : 'libs/jquery/inview/jquery.inview',
		'endless' : 'libs/jquery-endless/js/jquery.endless-scroll',
		'handlebars' : 'libs/handlebars/1.0.rc.1/handlebars',
		'ember' : 'libs/ember/1.0.0-pre2.1/ember',
		'ember_data' : 'libs/ember/data/ember-data-latest'
	}
});
