define({
  app_name: "BooksApp",
  shim: {
    'ember': {
      deps: ['handlebars', 'jquery'],
      exports: 'Ember'
    },
    'ember_data': {
      deps: ['ember'],
      exports: 'DS'
    },
    'inview': {
      deps: ['jquery'],
      exports: 'inview'
    },
    'handlebars': {
      exports: 'handlebars'
    },
    'bootstrap': {
      deps: ['jquery']
    },
    'spin': {
      deps: ['jquery'],
      exports: 'spin'
    },
    'modernizr': {
      exports: 'modernizr'
    },
    waitSeconds: 15
  },
  paths: {
    'App': 'app/main',
    'models': 'app/models',
    'views': 'app/views',
    'routes': 'app/routes',
    'controllers': 'app/controllers',
    'templates': 'app/templates',
    'helpers': 'app/helpers',

    /* libs */
    'jquery': 'libs/jquery',
    'inview': 'libs/jquery.inview',
    'handlebars': 'libs/handlebars',
    'ember': 'libs/ember',
    'ember_data': 'libs/ember-data',
    'bootstrap': 'libs/bootstrap/js/bootstrap',
    'modernizr': 'libs/modernizr',
    'spin': 'libs/spin'
  }
});