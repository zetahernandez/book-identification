(function (root) {
  require(["config"], function (config) {
    requirejs.config(config);
    require(["App", "ember", "ember_data", "inview", "bootstrap", "spin"], function (App, Ember, DS, inview, bootsrap, spin) {
      var app_name = config.app_name || "App";

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
      Ember.$(document).ajaxSend(function (evt, request, settings) {
        spinner.spin(Ember.$('#spinner_center')[0]);
        ajax_cnt++;
        console.log('send: ' + ajax_cnt);
      });
      Ember.$(document).ajaxComplete(function () {
        ajax_cnt--;
        console.log('stop: ' + ajax_cnt);
        if (ajax_cnt == 0) {
          spinner.stop();
          // $('#spinner_center').remove();
          ajax_cnt = 0;
        }
      });
      root[app_name] = App;
    });
  });
})(this);