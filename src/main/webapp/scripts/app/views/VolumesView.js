define([
	"ember",
	"text!templates/volumesTemplate.handlerbars"
], function(Ember, volumesTemplate){
	var VolumesView = Ember.View.extend({
	  template: Ember.Handlebars.compile(volumesTemplate)
	});
	return VolumesView;
});
