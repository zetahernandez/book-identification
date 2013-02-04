define([ "require", "ember"], function(r,Ember) {
    var VolumeListController = Ember.ArrayController.extend({
        page:1,
        category: null,
        
        init: function (){
          this.showAll();
        },
        
        filterByCategory : function(category) {
            this.category = category;
            var content = BooksApp.Volume.find({
                "categoryId": category.get('id'),"page":1
                });
                this.set('content',content);
        },
        
        showAll : function() {
            this.set("page",1);
            this.set('content',	BooksApp.Volume.find({
                "page":1
            }));
        },
        
        contentChanged: function() {
            var mutableVolumes = [];
            this.get('content').forEach(function(vol) {
                mutableVolumes.pushObject(vol);
            });
            this.set('currentVolumes', mutableVolumes);
        }.observes('content', 'content.isLoaded'),
        
        showVolumeInfo: function(event) {
        	BooksApp.router.applicationController.connectOutlet({
        		name : 'volumeInfoDetail',
				context : event.context,
				outletName : 'center'
			});
        },
        
        addMoreVolumes : function ( page ){
            
           var mutableVolumes = [],  data = {};
            this.page = page;
            
            if ( this.category != null){
               data.categoryId = this.category.get("id");
            }
            if(BooksApp.router.searchVolumeController.searchText != null){
            	data.q = BooksApp.router.searchVolumeController.searchText;
            }
            data.page = page;
            BooksApp.Volume.find( data );
            var books = BooksApp.Volume.find();
            var currentVolumes = this.get('currentVolumes');
            books.forEach(function(vol) {
            	if(!currentVolumes.contains(vol)){
            		mutableVolumes.pushObject(vol);
            	}
            });
            this.get('currentVolumes').pushObjects( mutableVolumes );
        }
    });
    return VolumeListController;
});