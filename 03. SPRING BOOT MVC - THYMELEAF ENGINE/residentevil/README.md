 how we show error for one field:
 
 <form th:action="@{/viruses/add}" method="post" th:object="${bindingModel}">
 
            <div class="form-group" th:classappend="${#fields.hasErrors('name')}? 'text-danger'">
			
                <label for="inputVirusName">Name</label>
				
                <input type="text" th:field="*{<b>name</b>}" class="form-control" id="inputVirusName">
				
                <small id="nameHelp" th:each="error : ${#fields.errors(<b>'name'</b>)}" th:text="${error}"></small>
				
            </div>
how we show errors for multiple fields:	
			

			
            <div class="form-group">
                <label for="inputVirusDescription" >Description</label>
                <textarea class="form-control" id="inputVirusDescription" rows="3" th:field="*{description}"></textarea>
            </div>
            <div class="form-group">
                <label for="inputVirusName">Side Effect</label>
                <input type="number" class="form-control" id="inputVirusSideEffect" th:field="*{sideEffects}">
            </div>
            <div class="form-group">
                <label for="inputVirusName">Creator</label>
                <input type="text" class="form-control" id="inputVirusCreator" th:field="*{creator}">
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="inputVirusIsDeadly" th:field="*{deadly}">
                <label class="form-check-label" for="inputVirusIsDeadly">
                    Is Deadly?
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="inputVirusIsCurable" th:field="*{curable}">
                <label class="form-check-label" for="inputVirusIsCurable">
                    Is Curable?
                </label>
            </div>
            <div class="form-check mt-4">
                <div th:each="mutation : ${T(residentevil.domain.entities.Mutation).values()}">
                    <input class="form-check-input" type="radio" name="exampleRadios" th:id="${{mutation}}"
                           th:value="${{mutation}}" th:field="*{mutation}" >
                    <label class="form-check-label" th:for="${{mutation}}" th:text="${mutation}" >
                    </label>
                </div>
            </div>
            <div class="form-check disabled">
                <input class="form-check-input" type="radio" name="exampleRadios" id="inputVirusSaveHumanity"
                       value="option3" disabled>
                <label class="form-check-label" for="inputVirusSaveHumanity">
                    Save Humanity
                </label>
            </div>
            <div class="form-group mt-4">
                <label for="inputVirusName">Turnover Rate</label>
                <input type="number" class="form-control" id="inputVirusTurnoverRate"  th:field="*{turnoverRate}">
            </div>
            <div class="form-group">
                <label for="inputVirusHoursUntilTurn">Hours Until Turn</label>
                <input type="number" class="form-control" id="inputVirusHoursUntilTurn"  th:field="*{hoursUntilTurn}">
            </div>
            <div class="form-group">
                <label for="inputVirusMagnitude">Magnitude</label>
                <select class="form-control" id="inputVirusMagnitude" th:field="*{magnitude}">
                    <option th:each="magnitude : ${T(residentevil.domain.entities.Magnitude).values()}" th:value="${magnitude}" th:text="${magnitude}" ></option>
                </select>
            </div>
            <div class="form-group">
                <label for="inputVirusReleaseDate">Release Date</label>
                <input type="date" class="form-control" id="inputVirusReleaseDate" th:field="*{releasedOn}">
            </div>
            <div class="form-group">
                <label for="inputVirusAffectedCapitals">Affected Capitals</label>
                <select multiple class="form-control" id="inputVirusAffectedCapitals" th:field="*{capitals}">
                    <option th:each="capital : ${capitalNames}" th:value="${capital.id}" th:text="${capital.name}"  ></option>
                </select>
            </div>
            <button class="btn re-background">Spread!</button>
        </form>


