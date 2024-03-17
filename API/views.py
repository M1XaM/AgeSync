from django.http import JsonResponse
from API.models import User, Event, UserEvent
from django.views.decorators.csrf import csrf_exempt
from django.utils import timezone
from datetime import datetime



@csrf_exempt
def sign_up(request):
    if request.method == 'POST':
        
        full_name = request.POST.get('full_name')
        login = request.POST.get('login')
        password = request.POST.get('password')

        # Check login availability
        try:
            User.objects.get(login=login)
        except User.DoesNotExist:
            new_user =  User(full_name=full_name, login=login, password=password)
            new_user.save()
            return JsonResponse({'status':'success', 'id':new_user.id})
        return JsonResponse({'status':'failed', 'id':-1})        
        

@csrf_exempt
def log_in(request):
    if request.method == 'POST':
        login = request.POST.get('login')
        password = request.POST.get('password')

        try:
            User.objects.get(login=login, password=password)
            return JsonResponse({'status': 'success'})
        except User.DoesNotExist:
            return JsonResponse({'status': 'failed'})

@csrf_exempt
def get_event_list(request):
    if request.method == 'GET':

        event_list = Event.objects.all()
        result = [{
            'id': event.id,
            'name': event.name,
            'description': event.description,
            'start_time': event.start_time,
            'end_time': event.end_time,
            'link': event.link,
        } for event in event_list]
        return JsonResponse(result, safe=False)


@csrf_exempt
def join_event(request):
    if request.method == 'POST':
        event_id = request.POST.get('event_id')
        user_login = request.POST.get('user_login')
        user_id = User.objects.get(login=user_login).id
        
        new_user_event = UserEvent(user=user_id, event=event_id)
        new_user_event.save()
        return JsonResponse({'status': 'success'})

@csrf_exempt
def get_subscribed_list(request):
    if request.method == 'GET':
        login = request.GET.get('login')
        user = User.objects.get(login=login)
        events_id = [event.id for event in UserEvent.objects.filter(user=user.id)]
        event_list = [Event.objects.get(id=event_id) for event_id in events_id]
        event_list = Event.objects.all()
        result = [{
            'id': event.id,
            'name': event.name,
            'description': event.description,
            'start_time': event.start_time,
            'end_time': event.end_time,
            'link': event.link,
        } for event in event_list]
        return JsonResponse(result, safe=False)


@csrf_exempt
def create_event(request):
    if request.method == 'POST':
        event_name = request.POST.get('name')
        event_type = request.POST.get('type')
        event_description = request.POST.get('description')

        start_time = datetime(2024, 3, 18, 12)
        end_time =datetime(2024, 3, 18, 14)
        # aware_start = timezone.make_aware(start_time)
        # aware_end = timezone.make_aware(end_time)

    try:
        if event_type == 'online':
            event_link = request.POST.get('link')
            new_event = Event(name=event_name, link=event_link,  description=event_description)
        elif event_type == 'offline':
            event_address = request.POST.get('address')
            new_event = Event(name=event_name, address=event_address,  description=event_description)
        elif event_type == 'online/offline':
            event_link = request.POST.get('link')
            event_address = request.POST.get('address')
            new_event = Event(name=event_name, link=event_link, address=event_address,  description=event_description)
    except:
        try:
            new_event = Event(name=event_name, link=event_link, address=event_address,  description=event_description)
        except:
            new_event = Event(name=event_name,  description=event_description)

    # new_event.start_time = aware_start
    # new_event.end_time = aware_end
        new_event.start_time = start_time
        new_event.end_time = end_time
        new_event.save()
        return JsonResponse({'status': 'success'}, status=200)

@csrf_exempt
def search(request):
    if request.method == 'POST':
        key_words = "-".split(request.POST.get('key-words'))
        result_list_event = []
        for event in Event.objects.all():
            for key_word in key_words:
                if  key_word in event.name or key_word in event.description:
                    result_list_event.append(event)
        
        result = [{
            'id': event.id,
            'name': event.name,
            'start_time': event.start_time,
            'end_time': event.end_time,
            'type' : event.type,
            'link' : event.link,
            'address' : event.address,
            'description': event.description,
        } for event in result_list_event]
        return JsonResponse(result, safe=False)


@csrf_exempt
def send_voice_command(request):
    pass
