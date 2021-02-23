<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" id="agregarSkinModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Skin</h5> 
                <button class="close" data-dismiss="modal"> <span>&times;</span> </button>
            </div>
            
            <form action="${pageContext.request.contextPath}/skin?action=insert" method="POST" class="was-validated">
                
                <div class="modal-body">
                	<div class="form-group">
                        <label for="name">Nombre de skin</label>
                        <input type="text" class="form-control" name="name" required />
                    </div>
                    <div class="form-group">
                        <label for="saldo">Saldo</label>
                        <input type="number" class="form-control" name="saldo" required step="any" />
                    </div>
                    <div class="form-group">
                        <label for="stock">Stock</label>
                        <input type="number" class="form-control" name="stock" required step="any" />
                    </div>
                    <div class="form-group">
                        <label for="cover">Cover</label>
                        <input type="text" class="form-control" name="cover" required />
                    </div>
                    <div class="form-group">
                        <label for="gameId">Juego</label>
                        <select class="form-control"  name="gameId" id="gameId">
                            <option value="1">RUST</option>
                            <option value="2">CS:GO</option>
                            <option value="3">DOTA 2</option>
                            <option value="4">LEAGUE OF LEGENDS</option>
                            <option value="5">FORTNITE</option>
                        </select>
                    </div>
                    
                    
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>    
            </form>
        </div>
    </div>
</div>
    