import { Injectable } from "@angular/core";
import { HttpRequest, HttpResponse, HttpHandler, HttpEvent, HTTP_INTERCEPTORS, HttpInterceptor } from "@angular/common/http";
import { Observable, of, throwError } from "rxjs";
import { delay, mergeMap, materialize, dematerialize } from "rxjs/operators";

//data from employee table
let users = [
    {
        id: 1,
        name: 'Quincy Roman',
        username: 'test1',
        password: 'test1',
        roleId: 3 //admin
    },
    {
        id: 2,
        name: 'Grayson McClellan',
        username: 'test2',
        password: 'test2',
        roleId: 3 //admin
    },
    {
        id: 3,
        name: 'Mareo Yapp',
        username: 'test3',
        password: 'test3',
        roleId: 3 //admin
    },
    {
        id: 4,
        name: 'Azhya Knox',
        username: 'test4',
        password: 'test4',
        roleId: 3 //admin
    }
];

/**
 * this class will be a representation of our backend.
 * 
 * FOR DEVELOPMENT PURPOSES ONLY!
 */

@Injectable()
export class FakeBackendInterceptor implements HttpInterceptor {
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        const { url, method, headers, body } = request;

        // wrap in delayed observable to simulate server api call
        return of(null)
            .pipe(mergeMap(handleRoute))
            .pipe(materialize()) // call materialize and dematerialize to ensure delay even if an error is thrown
            .pipe(delay(500))
            .pipe(dematerialize());



        function handleRoute() {
            switch (true) {
                case url.endsWith('/signin/authenticate') && method === 'POST':
                    return authenticate();
                default:
                    // pass through any requests not handled above
                    return next.handle(request);
            }
        }

    // route functions

    function authenticate() {
        const { username, password } = body;
        const user = users.find(x => x.username === username && x.password === password);
        if (!user) return error('Username or password is incorrect');
        return ok({
            id: user.id,
            name: user.name,
            username: user.username,
            token: 'fake-jwt-token'
        })
    }

    // helper functions

    function ok(body: any) {
        return of(new HttpResponse({ status: 200, body }))
    }

    function error(message: any) {
        return throwError({ error: { message } });
    }
}
}

export const fakeBackendProvider = {
// use fake backend in place of Http service for backend-less development
provide: HTTP_INTERCEPTORS,
useClass: FakeBackendInterceptor,
multi: true
};
