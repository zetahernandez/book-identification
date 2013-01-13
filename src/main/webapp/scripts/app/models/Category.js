define([ "require", "ember", "ember_data"], function(require, Ember) {
	var Category = DS.Model.extend({
		id : DS.attr('number'),
		categoryName : DS.attr('string'),
		parent :DS.belongsTo('BooksApp.Category', { embedded: true }),
		subCategories: DS.hasMany('BooksApp.Category'),
		
		haveParent : function() {
			return parent != undefined;
		},
		categoryLevel : function(category) {
			var level = 0;
			if (category.haveParent) {
				level = level + categoryLevel(category.parent) + 1;
			}
			return level;
		}
		
		
	});
	return Category;
});