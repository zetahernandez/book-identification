define([ "require", "ember", "ember_data"], function(require, Ember) {
	var IamgeLink = DS.Model.extend({
		id : DS.attr('number'),
		thumbnail : DS.attr('string'),
		small_thumbnail : DS.attr('string'),
		small : DS.attr('string'),
		medium : DS.attr('string'),
		large : DS.attr('string'),
		extraLarge : DS.attr('string')
	});
	return IamgeLink;
});