from django.urls import path
from API import views

urlpatterns = [
    path('sign_up', views.sign_up),
    path('log_in', views.log_in),
    path('get_event_list', views.get_event_list),
    path('join_event', views.join_event),
    path('get_subscribed_list', views.get_subscribed_list),
    path('create_event', views.create_event),
    path('search', views.search),
    path('send_voice_command', views.send_voice_command),
]