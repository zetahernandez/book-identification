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
      exports: 'spin',
      init: function ($) {
        var opts = {
          lines: 13, // The number of lines to draw
          length: 7, // The length of each line
          width: 4, // The line thickness
          radius: 10, // The radius of the inner circle
          rotate: 0, // The rotation offset
          color: '#efefef', // #rgb or #rrggbb
          speed: 0.75, // Rounds per second
          trail: 50, // Afterglow percentage
          shadow: true, // Whether to render a shadow
          hwaccel: false, // Whether to use hardware acceleration
          className: 'spinner', // The CSS class to assign to the spinner
          zIndex: 2e9, // The z-index (defaults to 2000000000)
          top: 'auto', // Top position relative to parent in px
          left: 'auto' // Left position relative to parent in px
        };
        var spinner = new Spinner(opts);
        var ajax_cnt = 0; // Support for parallel AJAX requests

        // Global functions to show/hide on ajax requests
        $(document).ajaxSend(function (evt, request, settings) {
          spinner.spin($('#spinner_center')[0]);
          ajax_cnt++;
        });
        $(document).ajaxComplete(function () {
          ajax_cnt--;
          if (ajax_cnt === 0) {
            spinner.stop();
            ajax_cnt = 0;
          }
        });
      }
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